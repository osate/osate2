package org.osate.xtext.aadl2.properties.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPropertiesLexer extends Lexer {
    public static final int RULE_DOTDOT=22;
    public static final int RULE_ID=6;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int RULE_ANY_OTHER=26;
    public static final int RULE_LBRACKET=16;
    public static final int EOF=-1;
    public static final int RULE_ASSIGN=14;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int RULE_DOT=15;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_LPARENS=10;
    public static final int RULE_INT=5;
    public static final int T__50=50;
    public static final int RULE_RBRACKET=17;
    public static final int RULE_SEMI=7;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int RULE_RPARENS=11;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_APPEND=23;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_LTRANS=19;
    public static final int RULE_COMMA=8;
    public static final int RULE_SL_COMMENT=21;
    public static final int RULE_NONE=18;
    public static final int RULE_ML_COMMENT=24;
    public static final int T__30=30;
    public static final int RULE_COLON=9;
    public static final int T__31=31;
    public static final int RULE_STRING=4;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_RTRANS=20;
    public static final int RULE_WS=25;
    public static final int RULE_RCURLY=13;
    public static final int RULE_LCURLY=12;

    // delegates
    // delegators

    public InternalPropertiesLexer() {;} 
    public InternalPropertiesLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalPropertiesLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g"; }

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11:7: ( 'and' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11:9: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:12:7: ( 'or' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:12:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:13:7: ( 'not' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:13:9: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:14:7: ( '*' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:14:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:15:7: ( 'false' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:15:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:16:7: ( '+' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:16:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:17:7: ( '-' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:17:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:18:7: ( 'property' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:18:9: 'property'
            {
            match("property"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:19:7: ( 'set' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:19:9: 'set'
            {
            match("set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:20:7: ( 'is' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:20:9: 'is'
            {
            match("is"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:21:7: ( 'end' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:21:9: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:22:7: ( 'with' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:22:9: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:23:7: ( 'type' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:23:9: 'type'
            {
            match("type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:24:7: ( 'aadlboolean' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:24:9: 'aadlboolean'
            {
            match("aadlboolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:25:7: ( 'aadlstring' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:25:9: 'aadlstring'
            {
            match("aadlstring"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:26:7: ( 'enumeration' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:26:9: 'enumeration'
            {
            match("enumeration"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:27:7: ( 'units' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:27:9: 'units'
            {
            match("units"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:28:7: ( 'aadlinteger' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:28:9: 'aadlinteger'
            {
            match("aadlinteger"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:29:7: ( 'classifier' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:29:9: 'classifier'
            {
            match("classifier"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:30:7: ( 'reference' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:30:9: 'reference'
            {
            match("reference"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:31:7: ( 'record' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:31:9: 'record'
            {
            match("record"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:32:7: ( 'applies' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:32:9: 'applies'
            {
            match("applies"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:33:7: ( 'to' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:33:9: 'to'
            {
            match("to"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:34:7: ( 'constant' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:34:9: 'constant'
            {
            match("constant"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:35:7: ( 'in' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:35:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:36:7: ( 'modes' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:36:9: 'modes'
            {
            match("modes"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:37:7: ( 'compute' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:37:9: 'compute'
            {
            match("compute"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:38:7: ( 'annex' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:38:9: 'annex'
            {
            match("annex"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:39:7: ( '::' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:39:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:40:7: ( 'inherit' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:40:9: 'inherit'
            {
            match("inherit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:41:7: ( 'all' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:41:9: 'all'
            {
            match("all"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:42:7: ( 'true' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:42:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "RULE_NONE"
    public final void mRULE_NONE() throws RecognitionException {
        try {
            int _type = RULE_NONE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11643:11: ( 'none' RULE_SEMI )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11643:13: 'none' RULE_SEMI
            {
            match("none"); 

            mRULE_SEMI(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NONE"

    // $ANTLR start "RULE_LTRANS"
    public final void mRULE_LTRANS() throws RecognitionException {
        try {
            int _type = RULE_LTRANS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11645:13: ( '-[' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11645:15: '-['
            {
            match("-["); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LTRANS"

    // $ANTLR start "RULE_RTRANS"
    public final void mRULE_RTRANS() throws RecognitionException {
        try {
            int _type = RULE_RTRANS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11647:13: ( ']->' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11647:15: ']->'
            {
            match("]->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RTRANS"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11649:17: ( '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11649:19: '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("--"); 

            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11649:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11649:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11649:40: ( ( '\\r' )? '\\n' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\n'||LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11649:41: ( '\\r' )? '\\n'
                    {
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11649:41: ( '\\r' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='\r') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11649:41: '\\r'
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

    // $ANTLR start "RULE_SEMI"
    public final void mRULE_SEMI() throws RecognitionException {
        try {
            int _type = RULE_SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11651:11: ( ';' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11651:13: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SEMI"

    // $ANTLR start "RULE_COLON"
    public final void mRULE_COLON() throws RecognitionException {
        try {
            int _type = RULE_COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11653:12: ( ':' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11653:14: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_COLON"

    // $ANTLR start "RULE_COMMA"
    public final void mRULE_COMMA() throws RecognitionException {
        try {
            int _type = RULE_COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11655:12: ( ',' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11655:14: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_COMMA"

    // $ANTLR start "RULE_DOT"
    public final void mRULE_DOT() throws RecognitionException {
        try {
            int _type = RULE_DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11657:10: ( '.' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11657:12: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOT"

    // $ANTLR start "RULE_DOTDOT"
    public final void mRULE_DOTDOT() throws RecognitionException {
        try {
            int _type = RULE_DOTDOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11659:13: ( '..' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11659:15: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOTDOT"

    // $ANTLR start "RULE_LPARENS"
    public final void mRULE_LPARENS() throws RecognitionException {
        try {
            int _type = RULE_LPARENS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11661:14: ( '(' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11661:16: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LPARENS"

    // $ANTLR start "RULE_RPARENS"
    public final void mRULE_RPARENS() throws RecognitionException {
        try {
            int _type = RULE_RPARENS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11663:14: ( ')' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11663:16: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RPARENS"

    // $ANTLR start "RULE_LBRACKET"
    public final void mRULE_LBRACKET() throws RecognitionException {
        try {
            int _type = RULE_LBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11665:15: ( '[' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11665:17: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LBRACKET"

    // $ANTLR start "RULE_RBRACKET"
    public final void mRULE_RBRACKET() throws RecognitionException {
        try {
            int _type = RULE_RBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11667:15: ( ']' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11667:17: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RBRACKET"

    // $ANTLR start "RULE_LCURLY"
    public final void mRULE_LCURLY() throws RecognitionException {
        try {
            int _type = RULE_LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11669:13: ( '{' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11669:15: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LCURLY"

    // $ANTLR start "RULE_RCURLY"
    public final void mRULE_RCURLY() throws RecognitionException {
        try {
            int _type = RULE_RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11671:13: ( '}' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11671:15: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RCURLY"

    // $ANTLR start "RULE_ASSIGN"
    public final void mRULE_ASSIGN() throws RecognitionException {
        try {
            int _type = RULE_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11673:13: ( '=>' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11673:15: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ASSIGN"

    // $ANTLR start "RULE_APPEND"
    public final void mRULE_APPEND() throws RecognitionException {
        try {
            int _type = RULE_APPEND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11675:13: ( '+=>' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11675:15: '+=>'
            {
            match("+=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_APPEND"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11677:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11677:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11677:11: ( '^' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='^') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11677:11: '^'
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

            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11677:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:
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
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11679:10: ( ( '0' .. '9' )+ )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11679:12: ( '0' .. '9' )+
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11679:12: ( '0' .. '9' )+
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
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11679:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11681:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11681:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11681:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\"') ) {
                alt9=1;
            }
            else if ( (LA9_0=='\'') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11681:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11681:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='!')||(LA7_0>='#' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11681:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11681:66: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop7;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11681:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11681:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\\') ) {
                            alt8=1;
                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<='&')||(LA8_0>='(' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11681:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11681:137: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop8;
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
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11683:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11683:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11683:24: ( options {greedy=false; } : . )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='*') ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1=='/') ) {
                        alt10=2;
                    }
                    else if ( ((LA10_1>='\u0000' && LA10_1<='.')||(LA10_1>='0' && LA10_1<='\uFFFF')) ) {
                        alt10=1;
                    }


                }
                else if ( ((LA10_0>='\u0000' && LA10_0<=')')||(LA10_0>='+' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11683:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop10;
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

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11685:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11685:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11685:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:
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
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11687:16: ( . )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:11687:18: .
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
        // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:8: ( T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | RULE_NONE | RULE_LTRANS | RULE_RTRANS | RULE_SL_COMMENT | RULE_SEMI | RULE_COLON | RULE_COMMA | RULE_DOT | RULE_DOTDOT | RULE_LPARENS | RULE_RPARENS | RULE_LBRACKET | RULE_RBRACKET | RULE_LCURLY | RULE_RCURLY | RULE_ASSIGN | RULE_APPEND | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=55;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:10: T__27
                {
                mT__27(); 

                }
                break;
            case 2 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:16: T__28
                {
                mT__28(); 

                }
                break;
            case 3 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:22: T__29
                {
                mT__29(); 

                }
                break;
            case 4 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:28: T__30
                {
                mT__30(); 

                }
                break;
            case 5 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:34: T__31
                {
                mT__31(); 

                }
                break;
            case 6 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:40: T__32
                {
                mT__32(); 

                }
                break;
            case 7 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:46: T__33
                {
                mT__33(); 

                }
                break;
            case 8 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:52: T__34
                {
                mT__34(); 

                }
                break;
            case 9 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:58: T__35
                {
                mT__35(); 

                }
                break;
            case 10 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:64: T__36
                {
                mT__36(); 

                }
                break;
            case 11 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:70: T__37
                {
                mT__37(); 

                }
                break;
            case 12 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:76: T__38
                {
                mT__38(); 

                }
                break;
            case 13 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:82: T__39
                {
                mT__39(); 

                }
                break;
            case 14 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:88: T__40
                {
                mT__40(); 

                }
                break;
            case 15 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:94: T__41
                {
                mT__41(); 

                }
                break;
            case 16 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:100: T__42
                {
                mT__42(); 

                }
                break;
            case 17 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:106: T__43
                {
                mT__43(); 

                }
                break;
            case 18 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:112: T__44
                {
                mT__44(); 

                }
                break;
            case 19 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:118: T__45
                {
                mT__45(); 

                }
                break;
            case 20 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:124: T__46
                {
                mT__46(); 

                }
                break;
            case 21 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:130: T__47
                {
                mT__47(); 

                }
                break;
            case 22 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:136: T__48
                {
                mT__48(); 

                }
                break;
            case 23 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:142: T__49
                {
                mT__49(); 

                }
                break;
            case 24 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:148: T__50
                {
                mT__50(); 

                }
                break;
            case 25 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:154: T__51
                {
                mT__51(); 

                }
                break;
            case 26 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:160: T__52
                {
                mT__52(); 

                }
                break;
            case 27 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:166: T__53
                {
                mT__53(); 

                }
                break;
            case 28 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:172: T__54
                {
                mT__54(); 

                }
                break;
            case 29 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:178: T__55
                {
                mT__55(); 

                }
                break;
            case 30 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:184: T__56
                {
                mT__56(); 

                }
                break;
            case 31 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:190: T__57
                {
                mT__57(); 

                }
                break;
            case 32 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:196: T__58
                {
                mT__58(); 

                }
                break;
            case 33 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:202: RULE_NONE
                {
                mRULE_NONE(); 

                }
                break;
            case 34 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:212: RULE_LTRANS
                {
                mRULE_LTRANS(); 

                }
                break;
            case 35 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:224: RULE_RTRANS
                {
                mRULE_RTRANS(); 

                }
                break;
            case 36 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:236: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 37 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:252: RULE_SEMI
                {
                mRULE_SEMI(); 

                }
                break;
            case 38 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:262: RULE_COLON
                {
                mRULE_COLON(); 

                }
                break;
            case 39 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:273: RULE_COMMA
                {
                mRULE_COMMA(); 

                }
                break;
            case 40 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:284: RULE_DOT
                {
                mRULE_DOT(); 

                }
                break;
            case 41 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:293: RULE_DOTDOT
                {
                mRULE_DOTDOT(); 

                }
                break;
            case 42 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:305: RULE_LPARENS
                {
                mRULE_LPARENS(); 

                }
                break;
            case 43 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:318: RULE_RPARENS
                {
                mRULE_RPARENS(); 

                }
                break;
            case 44 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:331: RULE_LBRACKET
                {
                mRULE_LBRACKET(); 

                }
                break;
            case 45 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:345: RULE_RBRACKET
                {
                mRULE_RBRACKET(); 

                }
                break;
            case 46 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:359: RULE_LCURLY
                {
                mRULE_LCURLY(); 

                }
                break;
            case 47 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:371: RULE_RCURLY
                {
                mRULE_RCURLY(); 

                }
                break;
            case 48 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:383: RULE_ASSIGN
                {
                mRULE_ASSIGN(); 

                }
                break;
            case 49 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:395: RULE_APPEND
                {
                mRULE_APPEND(); 

                }
                break;
            case 50 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:407: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 51 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:415: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 52 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:424: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 53 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:436: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 54 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:452: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 55 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1:460: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\3\51\1\uffff\1\51\1\57\1\62\12\51\1\102\1\104\2\uffff"+
        "\1\110\5\uffff\2\44\2\uffff\3\44\2\uffff\4\51\1\uffff\1\130\1\51"+
        "\1\uffff\1\51\5\uffff\2\51\1\136\1\140\3\51\1\145\6\51\22\uffff"+
        "\1\156\3\51\1\162\1\uffff\1\163\3\51\1\167\1\uffff\1\51\1\uffff"+
        "\1\171\3\51\1\uffff\10\51\1\uffff\3\51\2\uffff\3\51\1\uffff\1\51"+
        "\1\uffff\1\51\1\u008f\1\u0090\1\u0091\7\51\1\u0099\4\51\1\uffff"+
        "\1\u009e\3\51\3\uffff\1\u00a2\5\51\1\u00a8\1\uffff\4\51\1\uffff"+
        "\3\51\1\uffff\4\51\1\u00b4\1\uffff\3\51\1\u00b8\1\51\1\u00ba\3\51"+
        "\1\u00be\1\51\1\uffff\3\51\1\uffff\1\u00c3\1\uffff\2\51\1\u00c6"+
        "\1\uffff\4\51\1\uffff\2\51\1\uffff\1\u00cd\1\51\1\u00cf\2\51\1\u00d2"+
        "\1\uffff\1\u00d3\1\uffff\1\u00d4\1\u00d5\4\uffff";
    static final String DFA12_eofS =
        "\u00d6\uffff";
    static final String DFA12_minS =
        "\1\0\1\141\1\162\1\157\1\uffff\1\141\1\75\1\55\1\162\1\145\2\156"+
        "\1\151\1\157\1\156\1\154\1\145\1\157\1\72\1\55\2\uffff\1\56\5\uffff"+
        "\1\76\1\101\2\uffff\2\0\1\52\2\uffff\2\144\1\160\1\154\1\uffff\1"+
        "\60\1\156\1\uffff\1\154\5\uffff\1\157\1\164\2\60\1\144\1\164\1\160"+
        "\1\60\1\165\1\151\1\141\1\155\1\143\1\144\22\uffff\1\60\1\145\2"+
        "\154\1\60\1\uffff\1\60\1\145\1\163\1\160\1\60\1\uffff\1\145\1\uffff"+
        "\1\60\1\155\1\150\1\145\1\uffff\1\145\1\164\2\163\1\160\1\145\1"+
        "\157\1\145\1\uffff\1\170\1\142\1\151\2\uffff\1\73\2\145\1\uffff"+
        "\1\162\1\uffff\1\145\3\60\2\163\1\164\1\165\2\162\1\163\1\60\1\157"+
        "\1\164\1\156\1\145\1\uffff\1\60\1\162\1\151\1\162\3\uffff\1\60\1"+
        "\151\1\141\1\164\1\145\1\144\1\60\1\uffff\1\157\1\162\1\164\1\163"+
        "\1\uffff\2\164\1\141\1\uffff\1\146\1\156\1\145\1\156\1\60\1\uffff"+
        "\1\154\1\151\1\145\1\60\1\171\1\60\1\164\1\151\1\164\1\60\1\143"+
        "\1\uffff\1\145\1\156\1\147\1\uffff\1\60\1\uffff\1\151\1\145\1\60"+
        "\1\uffff\1\145\1\141\1\147\1\145\1\uffff\1\157\1\162\1\uffff\1\60"+
        "\1\156\1\60\1\162\1\156\1\60\1\uffff\1\60\1\uffff\2\60\4\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\160\1\162\1\157\1\uffff\1\141\1\75\1\133\1\162\1\145"+
        "\1\163\1\156\1\151\1\171\1\156\1\157\1\145\1\157\1\72\1\55\2\uffff"+
        "\1\56\5\uffff\1\76\1\172\2\uffff\2\uffff\1\52\2\uffff\1\156\1\144"+
        "\1\160\1\154\1\uffff\1\172\1\164\1\uffff\1\154\5\uffff\1\157\1\164"+
        "\2\172\1\165\1\164\1\160\1\172\1\165\1\151\1\141\1\156\1\146\1\144"+
        "\22\uffff\1\172\1\145\2\154\1\172\1\uffff\1\172\1\145\1\163\1\160"+
        "\1\172\1\uffff\1\145\1\uffff\1\172\1\155\1\150\1\145\1\uffff\1\145"+
        "\1\164\2\163\1\160\1\145\1\157\1\145\1\uffff\1\170\1\163\1\151\2"+
        "\uffff\1\73\2\145\1\uffff\1\162\1\uffff\1\145\3\172\2\163\1\164"+
        "\1\165\2\162\1\163\1\172\1\157\1\164\1\156\1\145\1\uffff\1\172\1"+
        "\162\1\151\1\162\3\uffff\1\172\1\151\1\141\1\164\1\145\1\144\1\172"+
        "\1\uffff\1\157\1\162\1\164\1\163\1\uffff\2\164\1\141\1\uffff\1\146"+
        "\1\156\1\145\1\156\1\172\1\uffff\1\154\1\151\1\145\1\172\1\171\1"+
        "\172\1\164\1\151\1\164\1\172\1\143\1\uffff\1\145\1\156\1\147\1\uffff"+
        "\1\172\1\uffff\1\151\1\145\1\172\1\uffff\1\145\1\141\1\147\1\145"+
        "\1\uffff\1\157\1\162\1\uffff\1\172\1\156\1\172\1\162\1\156\1\172"+
        "\1\uffff\1\172\1\uffff\2\172\4\uffff";
    static final String DFA12_acceptS =
        "\4\uffff\1\4\17\uffff\1\45\1\47\1\uffff\1\52\1\53\1\54\1\56\1\57"+
        "\2\uffff\1\62\1\63\3\uffff\1\66\1\67\4\uffff\1\62\2\uffff\1\4\1"+
        "\uffff\1\61\1\6\1\42\1\44\1\7\16\uffff\1\35\1\46\1\43\1\55\1\45"+
        "\1\47\1\51\1\50\1\52\1\53\1\54\1\56\1\57\1\60\1\63\1\64\1\65\1\66"+
        "\5\uffff\1\2\5\uffff\1\12\1\uffff\1\31\4\uffff\1\27\10\uffff\1\1"+
        "\3\uffff\1\37\1\3\3\uffff\1\11\1\uffff\1\13\20\uffff\1\41\4\uffff"+
        "\1\14\1\15\1\40\7\uffff\1\34\4\uffff\1\5\3\uffff\1\21\5\uffff\1"+
        "\32\13\uffff\1\25\3\uffff\1\26\1\uffff\1\36\3\uffff\1\33\4\uffff"+
        "\1\10\2\uffff\1\30\6\uffff\1\24\1\uffff\1\17\2\uffff\1\23\1\16\1"+
        "\22\1\20";
    static final String DFA12_specialS =
        "\1\0\37\uffff\1\2\1\1\u00b4\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\44\2\43\2\44\1\43\22\44\1\43\1\44\1\40\4\44\1\41\1\27\1"+
            "\30\1\4\1\6\1\25\1\7\1\26\1\42\12\37\1\22\1\24\1\44\1\34\3\44"+
            "\32\36\1\31\1\44\1\23\1\35\1\36\1\44\1\1\1\36\1\17\1\36\1\13"+
            "\1\5\2\36\1\12\3\36\1\21\1\3\1\2\1\10\1\36\1\20\1\11\1\15\1"+
            "\16\1\36\1\14\3\36\1\32\1\44\1\33\uff82\44",
            "\1\46\12\uffff\1\50\1\uffff\1\45\1\uffff\1\47",
            "\1\52",
            "\1\53",
            "",
            "\1\55",
            "\1\56",
            "\1\61\55\uffff\1\60",
            "\1\63",
            "\1\64",
            "\1\66\4\uffff\1\65",
            "\1\67",
            "\1\70",
            "\1\72\2\uffff\1\73\6\uffff\1\71",
            "\1\74",
            "\1\75\2\uffff\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\103",
            "",
            "",
            "\1\107",
            "",
            "",
            "",
            "",
            "",
            "\1\116",
            "\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "\0\120",
            "\0\120",
            "\1\121",
            "",
            "",
            "\1\123\11\uffff\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\132\5\uffff\1\131",
            "",
            "\1\133",
            "",
            "",
            "",
            "",
            "",
            "\1\134",
            "\1\135",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\7\51\1\137\22\51",
            "\1\141\20\uffff\1\142",
            "\1\143",
            "\1\144",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\152\1\151",
            "\1\154\2\uffff\1\153",
            "\1\155",
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
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\157",
            "\1\160",
            "\1\161",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\164",
            "\1\165",
            "\1\166",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\1\170",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\172",
            "\1\173",
            "\1\174",
            "",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "",
            "\1\u0085",
            "\1\u0086\6\uffff\1\u0088\11\uffff\1\u0087",
            "\1\u0089",
            "",
            "",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "",
            "\1\u008d",
            "",
            "\1\u008e",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "",
            "",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00b9",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00bf",
            "",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\1\u00c4",
            "\1\u00c5",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "",
            "\1\u00cb",
            "\1\u00cc",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00ce",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00d0",
            "\1\u00d1",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
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
            return "1:1: Tokens : ( T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | RULE_NONE | RULE_LTRANS | RULE_RTRANS | RULE_SL_COMMENT | RULE_SEMI | RULE_COLON | RULE_COMMA | RULE_DOT | RULE_DOTDOT | RULE_LPARENS | RULE_RPARENS | RULE_LBRACKET | RULE_RBRACKET | RULE_LCURLY | RULE_RCURLY | RULE_ASSIGN | RULE_APPEND | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='a') ) {s = 1;}

                        else if ( (LA12_0=='o') ) {s = 2;}

                        else if ( (LA12_0=='n') ) {s = 3;}

                        else if ( (LA12_0=='*') ) {s = 4;}

                        else if ( (LA12_0=='f') ) {s = 5;}

                        else if ( (LA12_0=='+') ) {s = 6;}

                        else if ( (LA12_0=='-') ) {s = 7;}

                        else if ( (LA12_0=='p') ) {s = 8;}

                        else if ( (LA12_0=='s') ) {s = 9;}

                        else if ( (LA12_0=='i') ) {s = 10;}

                        else if ( (LA12_0=='e') ) {s = 11;}

                        else if ( (LA12_0=='w') ) {s = 12;}

                        else if ( (LA12_0=='t') ) {s = 13;}

                        else if ( (LA12_0=='u') ) {s = 14;}

                        else if ( (LA12_0=='c') ) {s = 15;}

                        else if ( (LA12_0=='r') ) {s = 16;}

                        else if ( (LA12_0=='m') ) {s = 17;}

                        else if ( (LA12_0==':') ) {s = 18;}

                        else if ( (LA12_0==']') ) {s = 19;}

                        else if ( (LA12_0==';') ) {s = 20;}

                        else if ( (LA12_0==',') ) {s = 21;}

                        else if ( (LA12_0=='.') ) {s = 22;}

                        else if ( (LA12_0=='(') ) {s = 23;}

                        else if ( (LA12_0==')') ) {s = 24;}

                        else if ( (LA12_0=='[') ) {s = 25;}

                        else if ( (LA12_0=='{') ) {s = 26;}

                        else if ( (LA12_0=='}') ) {s = 27;}

                        else if ( (LA12_0=='=') ) {s = 28;}

                        else if ( (LA12_0=='^') ) {s = 29;}

                        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||LA12_0=='b'||LA12_0=='d'||(LA12_0>='g' && LA12_0<='h')||(LA12_0>='j' && LA12_0<='l')||LA12_0=='q'||LA12_0=='v'||(LA12_0>='x' && LA12_0<='z')) ) {s = 30;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 31;}

                        else if ( (LA12_0=='\"') ) {s = 32;}

                        else if ( (LA12_0=='\'') ) {s = 33;}

                        else if ( (LA12_0=='/') ) {s = 34;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 35;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||LA12_0=='<'||(LA12_0>='>' && LA12_0<='@')||LA12_0=='\\'||LA12_0=='`'||LA12_0=='|'||(LA12_0>='~' && LA12_0<='\uFFFF')) ) {s = 36;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_33 = input.LA(1);

                        s = -1;
                        if ( ((LA12_33>='\u0000' && LA12_33<='\uFFFF')) ) {s = 80;}

                        else s = 36;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_32 = input.LA(1);

                        s = -1;
                        if ( ((LA12_32>='\u0000' && LA12_32<='\uFFFF')) ) {s = 80;}

                        else s = 36;

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