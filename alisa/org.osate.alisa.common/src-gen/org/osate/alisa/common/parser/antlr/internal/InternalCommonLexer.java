package org.osate.alisa.common.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCommonLexer extends Lexer {
    public static final int RULE_HEX=8;
    public static final int T__50=50;
<<<<<<< HEAD
    public static final int RULE_INT_EXPONENT=13;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
=======
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
>>>>>>> refs/remotes/origin/PeterWork
    public static final int T__51=51;
<<<<<<< HEAD
    public static final int T__52=52;
    public static final int RULE_BASED_INTEGER=14;
    public static final int T__53=53;
    public static final int T__54=54;
=======
>>>>>>> refs/remotes/origin/PeterWork
    public static final int RULE_ID=5;
    public static final int RULE_DIGIT=11;
    public static final int RULE_DECIMAL=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=9;
    public static final int T__29=29;
    public static final int T__22=22;
<<<<<<< HEAD
    public static final int RULE_ML_COMMENT=16;
=======
    public static final int RULE_ML_COMMENT=9;
>>>>>>> refs/remotes/origin/PeterWork
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
<<<<<<< HEAD
    public static final int RULE_INTEGER_LIT=6;
=======
>>>>>>> refs/remotes/origin/PeterWork
    public static final int T__21=21;
<<<<<<< HEAD
    public static final int RULE_REAL_LIT=7;
=======
>>>>>>> refs/remotes/origin/PeterWork
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=17;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
<<<<<<< HEAD
    public static final int RULE_WS=18;
    public static final int RULE_ANY_OTHER=19;
    public static final int RULE_EXPONENT=12;
=======
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
>>>>>>> refs/remotes/origin/PeterWork
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
<<<<<<< HEAD
    public static final int RULE_EXTENDED_DIGIT=15;
=======
>>>>>>> refs/remotes/origin/PeterWork
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators

    public InternalCommonLexer() {;} 
    public InternalCommonLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalCommonLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g"; }

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:11:7: ( 'description' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:11:9: 'description'
            {
            match("description"); 

<<<<<<< HEAD
=======

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:12:7: ( 'this' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:12:9: 'this'
            {
            match("this"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:13:7: ( '%' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:13:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:14:7: ( 'img' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:14:9: 'img'
            {
            match("img"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:15:7: ( '/' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:15:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:16:7: ( '.' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:16:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:17:7: ( '||' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:17:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:18:7: ( '&&' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:18:9: '&&'
            {
            match("&&"); 

>>>>>>> refs/remotes/origin/PeterWork

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:12:7: ( 'this' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:12:9: 'this'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:19:7: ( '==' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:19:9: '=='
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            match("this"); 
=======
            match("=="); 
>>>>>>> refs/remotes/origin/PeterWork


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:13:7: ( '%' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:13:9: '%'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:20:7: ( '!=' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:20:9: '!='
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            match('%'); 
=======
            match("!="); 

>>>>>>> refs/remotes/origin/PeterWork

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:14:7: ( 'img' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:14:9: 'img'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:21:7: ( '===' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:21:9: '==='
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            match("img"); 
=======
            match("==="); 
>>>>>>> refs/remotes/origin/PeterWork


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:15:7: ( '/' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:15:9: '/'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:22:7: ( '!==' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:22:9: '!=='
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            match('/'); 
=======
            match("!=="); 

>>>>>>> refs/remotes/origin/PeterWork

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:16:7: ( '.' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:16:9: '.'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:23:7: ( '>=' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:23:9: '>='
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            match('.'); 
=======
            match(">="); 

>>>>>>> refs/remotes/origin/PeterWork

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:17:7: ( '||' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:17:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:18:7: ( '&&' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:18:9: '&&'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:25:7: ( '=' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:25:9: '='
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            match("&&"); 

=======
            match('='); 
>>>>>>> refs/remotes/origin/PeterWork

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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:19:7: ( '==' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:19:9: '=='
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:26:7: ( '>' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:26:9: '>'
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            match("=="); 

=======
            match('>'); 
>>>>>>> refs/remotes/origin/PeterWork

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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:20:7: ( '!=' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:20:9: '!='
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:27:7: ( '->' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:27:9: '->'
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            match("!="); 
=======
            match("->"); 
>>>>>>> refs/remotes/origin/PeterWork


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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:21:7: ( '===' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:21:9: '==='
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:28:7: ( '..<' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:28:9: '..<'
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            match("==="); 
=======
            match("..<"); 
>>>>>>> refs/remotes/origin/PeterWork


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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:22:7: ( '!==' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:22:9: '!=='
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:29:7: ( '..' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:29:9: '..'
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            match("!=="); 
=======
            match(".."); 
>>>>>>> refs/remotes/origin/PeterWork


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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:23:7: ( '>=' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:23:9: '>='
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:30:7: ( '=>' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:30:9: '=>'
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            match(">="); 
=======
            match("=>"); 
>>>>>>> refs/remotes/origin/PeterWork


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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:24:7: ( '<' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:24:9: '<'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:31:7: ( '<>' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:31:9: '<>'
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            match('<'); 
=======
            match("<>"); 

>>>>>>> refs/remotes/origin/PeterWork

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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:25:7: ( '=' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:25:9: '='
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:32:7: ( '?:' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:32:9: '?:'
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            match('='); 
=======
            match("?:"); 

>>>>>>> refs/remotes/origin/PeterWork

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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:26:7: ( '>' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:26:9: '>'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:33:7: ( '+' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:33:9: '+'
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            match('>'); 
=======
            match('+'); 
>>>>>>> refs/remotes/origin/PeterWork

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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:27:7: ( '->' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:27:9: '->'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:34:7: ( '-' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:34:9: '-'
>>>>>>> refs/remotes/origin/PeterWork
            {
            match('-'); 

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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:28:7: ( '..<' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:28:9: '..<'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:35:7: ( '*' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:35:9: '*'
>>>>>>> refs/remotes/origin/PeterWork
            {
            match('*'); 

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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:29:7: ( '..' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:29:9: '..'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:36:7: ( '**' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:36:9: '**'
>>>>>>> refs/remotes/origin/PeterWork
            {
            match("**"); 


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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:30:7: ( '=>' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:30:9: '=>'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:37:7: ( '!' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:37:9: '!'
>>>>>>> refs/remotes/origin/PeterWork
            {
            match('!'); 

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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:31:7: ( '<>' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:31:9: '<>'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:38:7: ( '#' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:38:9: '#'
>>>>>>> refs/remotes/origin/PeterWork
            {
            match('#'); 

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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:32:7: ( '?:' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:32:9: '?:'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:39:7: ( '{' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:39:9: '{'
>>>>>>> refs/remotes/origin/PeterWork
            {
            match('{'); 

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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:33:7: ( '+' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:33:9: '+'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:40:7: ( ',' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:40:9: ','
>>>>>>> refs/remotes/origin/PeterWork
            {
            match(','); 

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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:34:7: ( '-' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:34:9: '-'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:41:7: ( '}' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:41:9: '}'
>>>>>>> refs/remotes/origin/PeterWork
            {
            match('}'); 

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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:35:7: ( '*' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:35:9: '*'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:42:7: ( '[' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:42:9: '['
>>>>>>> refs/remotes/origin/PeterWork
            {
            match('['); 

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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:36:7: ( '**' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:36:9: '**'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:43:7: ( ']' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:43:9: ']'
>>>>>>> refs/remotes/origin/PeterWork
            {
            match(']'); 

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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:37:7: ( '!' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:37:9: '!'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:44:7: ( '(' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:44:9: '('
>>>>>>> refs/remotes/origin/PeterWork
            {
            match('('); 

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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:38:7: ( '{' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:38:9: '{'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:45:7: ( ')' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:45:9: ')'
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            match('{'); 
=======
            match(')'); 
>>>>>>> refs/remotes/origin/PeterWork

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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:39:7: ( ',' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:39:9: ','
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:46:7: ( 'false' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:46:9: 'false'
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            match(','); 
=======
            match("false"); 

>>>>>>> refs/remotes/origin/PeterWork

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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:40:7: ( '}' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:40:9: '}'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:47:7: ( 'true' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:47:9: 'true'
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            match('}'); 
=======
            match("true"); 

>>>>>>> refs/remotes/origin/PeterWork

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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:41:7: ( '#' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:41:9: '#'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:48:7: ( 'null' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:48:9: 'null'
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            match('#'); 
=======
            match("null"); 

>>>>>>> refs/remotes/origin/PeterWork

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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:42:7: ( '[' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:42:9: '['
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:49:7: ( '::' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:49:9: '::'
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            match('['); 
=======
            match("::"); 

>>>>>>> refs/remotes/origin/PeterWork

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

<<<<<<< HEAD
    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:43:7: ( ']' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:43:9: ']'
            {
            match(']'); 

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
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:44:7: ( '(' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:44:9: '('
            {
            match('('); 

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
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:45:7: ( ')' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:45:9: ')'
            {
            match(')'); 

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
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:46:7: ( 'true' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:46:9: 'true'
            {
            match("true"); 


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
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:47:7: ( 'false' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:47:9: 'false'
            {
            match("false"); 


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
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:48:7: ( 'null' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:48:9: 'null'
            {
            match("null"); 


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
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:49:7: ( '::' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:49:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "RULE_EXPONENT"
    public final void mRULE_EXPONENT() throws RecognitionException {
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2264:24: ( ( 'e' | 'E' ) ( '+' | '-' )? ( RULE_DIGIT )+ )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2264:26: ( 'e' | 'E' ) ( '+' | '-' )? ( RULE_DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2264:36: ( '+' | '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='+'||LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:
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

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2264:47: ( RULE_DIGIT )+
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
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2264:47: RULE_DIGIT
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
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2266:28: ( ( 'e' | 'E' ) ( '+' )? ( RULE_DIGIT )+ )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2266:30: ( 'e' | 'E' ) ( '+' )? ( RULE_DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2266:40: ( '+' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='+') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2266:40: '+'
                    {
                    match('+'); 

                    }
                    break;

            }

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2266:45: ( RULE_DIGIT )+
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
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2266:45: RULE_DIGIT
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
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2268:15: ( ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* '.' ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( RULE_EXPONENT )? )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2268:17: ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* '.' ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( RULE_EXPONENT )?
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2268:17: ( RULE_DIGIT )+
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
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2268:17: RULE_DIGIT
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

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2268:29: ( '_' ( RULE_DIGIT )+ )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='_') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2268:30: '_' ( RULE_DIGIT )+
            	    {
            	    match('_'); 
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2268:34: ( RULE_DIGIT )+
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
            	    	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2268:34: RULE_DIGIT
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
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2268:52: ( RULE_DIGIT )+
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
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2268:52: RULE_DIGIT
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

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2268:64: ( '_' ( RULE_DIGIT )+ )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='_') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2268:65: '_' ( RULE_DIGIT )+
            	    {
            	    match('_'); 
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2268:69: ( RULE_DIGIT )+
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
            	    	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2268:69: RULE_DIGIT
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

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2268:83: ( RULE_EXPONENT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='E'||LA11_0=='e') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2268:83: RULE_EXPONENT
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
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2270:18: ( ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( '#' RULE_BASED_INTEGER '#' ( RULE_INT_EXPONENT )? | ( RULE_INT_EXPONENT )? ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2270:20: ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( '#' RULE_BASED_INTEGER '#' ( RULE_INT_EXPONENT )? | ( RULE_INT_EXPONENT )? )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2270:20: ( RULE_DIGIT )+
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
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2270:20: RULE_DIGIT
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

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2270:32: ( '_' ( RULE_DIGIT )+ )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='_') ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2270:33: '_' ( RULE_DIGIT )+
            	    {
            	    match('_'); 
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2270:37: ( RULE_DIGIT )+
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
            	    	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2270:37: RULE_DIGIT
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

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2270:51: ( '#' RULE_BASED_INTEGER '#' ( RULE_INT_EXPONENT )? | ( RULE_INT_EXPONENT )? )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='#') ) {
                alt17=1;
            }
            else {
                alt17=2;}
            switch (alt17) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2270:52: '#' RULE_BASED_INTEGER '#' ( RULE_INT_EXPONENT )?
                    {
                    match('#'); 
                    mRULE_BASED_INTEGER(); 
                    match('#'); 
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2270:79: ( RULE_INT_EXPONENT )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='E'||LA15_0=='e') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2270:79: RULE_INT_EXPONENT
                            {
                            mRULE_INT_EXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2270:98: ( RULE_INT_EXPONENT )?
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2270:98: ( RULE_INT_EXPONENT )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='E'||LA16_0=='e') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2270:98: RULE_INT_EXPONENT
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
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2272:21: ( '0' .. '9' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2272:23: '0' .. '9'
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
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2274:30: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2274:32: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
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
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2276:29: ( RULE_EXTENDED_DIGIT ( ( '_' )? RULE_EXTENDED_DIGIT )* )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2276:31: RULE_EXTENDED_DIGIT ( ( '_' )? RULE_EXTENDED_DIGIT )*
            {
            mRULE_EXTENDED_DIGIT(); 
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2276:51: ( ( '_' )? RULE_EXTENDED_DIGIT )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='0' && LA19_0<='9')||(LA19_0>='A' && LA19_0<='F')||LA19_0=='_'||(LA19_0>='a' && LA19_0<='f')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2276:52: ( '_' )? RULE_EXTENDED_DIGIT
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2276:52: ( '_' )?
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0=='_') ) {
            	        alt18=1;
            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2276:52: '_'
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

=======
>>>>>>> refs/remotes/origin/PeterWork
    // $ANTLR start "RULE_HEX"
    public final void mRULE_HEX() throws RecognitionException {
        try {
            int _type = RULE_HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2278:10: ( ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+ ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )? )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2278:12: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+ ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )?
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2073:10: ( ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+ ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )? )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2073:12: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+ ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )?
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2278:12: ( '0x' | '0X' )
            int alt20=2;
            int LA20_0 = input.LA(1);
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2073:12: ( '0x' | '0X' )
            int alt1=2;
            int LA1_0 = input.LA(1);
>>>>>>> refs/remotes/origin/PeterWork

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
<<<<<<< HEAD
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2278:13: '0x'
=======
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2073:13: '0x'
>>>>>>> refs/remotes/origin/PeterWork
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
<<<<<<< HEAD
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2278:18: '0X'
=======
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2073:18: '0X'
>>>>>>> refs/remotes/origin/PeterWork
                    {
                    match("0X"); 


                    }
                    break;

            }

<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2278:24: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+
            int cnt21=0;
            loop21:
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2073:24: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+
            int cnt2=0;
            loop2:
>>>>>>> refs/remotes/origin/PeterWork
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>='0' && LA21_0<='9')||(LA21_0>='A' && LA21_0<='F')||LA21_0=='_'||(LA21_0>='a' && LA21_0<='f')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:
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

<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2278:58: ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2073:58: ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);
>>>>>>> refs/remotes/origin/PeterWork

            if ( (LA23_0=='#') ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
<<<<<<< HEAD
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2278:59: '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) )
=======
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2073:59: '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) )
>>>>>>> refs/remotes/origin/PeterWork
                    {
                    match('#'); 
<<<<<<< HEAD
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2278:63: ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) )
                    int alt22=2;
                    int LA22_0 = input.LA(1);
=======
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2073:63: ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) )
                    int alt3=2;
                    int LA3_0 = input.LA(1);
>>>>>>> refs/remotes/origin/PeterWork

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
<<<<<<< HEAD
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2278:64: ( 'b' | 'B' ) ( 'i' | 'I' )
=======
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2073:64: ( 'b' | 'B' ) ( 'i' | 'I' )
>>>>>>> refs/remotes/origin/PeterWork
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
<<<<<<< HEAD
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2278:84: ( 'l' | 'L' )
=======
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2073:84: ( 'l' | 'L' )
>>>>>>> refs/remotes/origin/PeterWork
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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2280:10: ( '0' .. '9' ( '0' .. '9' | '_' )* )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2280:12: '0' .. '9' ( '0' .. '9' | '_' )*
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2075:10: ( '0' .. '9' ( '0' .. '9' | '_' )* )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2075:12: '0' .. '9' ( '0' .. '9' | '_' )*
>>>>>>> refs/remotes/origin/PeterWork
            {
            matchRange('0','9'); 
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2280:21: ( '0' .. '9' | '_' )*
            loop24:
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2075:21: ( '0' .. '9' | '_' )*
            loop5:
>>>>>>> refs/remotes/origin/PeterWork
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>='0' && LA24_0<='9')||LA24_0=='_') ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:
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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2282:14: ( RULE_INT ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )? ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )? )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2282:16: RULE_INT ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )? ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )?
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2077:14: ( RULE_INT ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )? ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )? )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2077:16: RULE_INT ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )? ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )?
>>>>>>> refs/remotes/origin/PeterWork
            {
            mRULE_INT(); 
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2282:25: ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )?
            int alt26=2;
            int LA26_0 = input.LA(1);
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2077:25: ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )?
            int alt7=2;
            int LA7_0 = input.LA(1);
>>>>>>> refs/remotes/origin/PeterWork

            if ( (LA26_0=='E'||LA26_0=='e') ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
<<<<<<< HEAD
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2282:26: ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT
=======
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2077:26: ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT
>>>>>>> refs/remotes/origin/PeterWork
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

<<<<<<< HEAD
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2282:36: ( '+' | '-' )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);
=======
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2077:36: ( '+' | '-' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);
>>>>>>> refs/remotes/origin/PeterWork

                    if ( (LA25_0=='+'||LA25_0=='-') ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:
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

<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2282:58: ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )?
            int alt27=3;
            int LA27_0 = input.LA(1);
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2077:58: ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )?
            int alt8=3;
            int LA8_0 = input.LA(1);
>>>>>>> refs/remotes/origin/PeterWork

            if ( (LA27_0=='B'||LA27_0=='b') ) {
                alt27=1;
            }
            else if ( (LA27_0=='D'||LA27_0=='F'||LA27_0=='L'||LA27_0=='d'||LA27_0=='f'||LA27_0=='l') ) {
                alt27=2;
            }
            switch (alt27) {
                case 1 :
<<<<<<< HEAD
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2282:59: ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' )
=======
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2077:59: ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' )
>>>>>>> refs/remotes/origin/PeterWork
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
<<<<<<< HEAD
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2282:87: ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' )
=======
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2077:87: ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' )
>>>>>>> refs/remotes/origin/PeterWork
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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2284:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2284:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2079:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2079:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2284:11: ( '^' )?
            int alt28=2;
            int LA28_0 = input.LA(1);
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2079:11: ( '^' )?
            int alt9=2;
            int LA9_0 = input.LA(1);
>>>>>>> refs/remotes/origin/PeterWork

            if ( (LA28_0=='^') ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
<<<<<<< HEAD
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2284:11: '^'
=======
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2079:11: '^'
>>>>>>> refs/remotes/origin/PeterWork
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

<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2284:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop29:
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2079:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop10:
>>>>>>> refs/remotes/origin/PeterWork
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

<<<<<<< HEAD
                if ( ((LA29_0>='0' && LA29_0<='9')||(LA29_0>='A' && LA29_0<='Z')||LA29_0=='_'||(LA29_0>='a' && LA29_0<='z')) ) {
                    alt29=1;
=======
                if ( ((LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='Z')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='z')) ) {
                    alt10=1;
>>>>>>> refs/remotes/origin/PeterWork
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:
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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2286:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2286:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2081:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2081:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2286:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt32=2;
            int LA32_0 = input.LA(1);
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2081:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt13=2;
            int LA13_0 = input.LA(1);
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
            if ( (LA32_0=='\"') ) {
                alt32=1;
=======
            if ( (LA13_0=='\"') ) {
                alt13=1;
>>>>>>> refs/remotes/origin/PeterWork
            }
<<<<<<< HEAD
            else if ( (LA32_0=='\'') ) {
                alt32=2;
=======
            else if ( (LA13_0=='\'') ) {
                alt13=2;
>>>>>>> refs/remotes/origin/PeterWork
            }
            else {
                NoViableAltException nvae =
<<<<<<< HEAD
                    new NoViableAltException("", 32, 0, input);
=======
                    new NoViableAltException("", 13, 0, input);
>>>>>>> refs/remotes/origin/PeterWork

                throw nvae;
            }
<<<<<<< HEAD
            switch (alt32) {
=======
            switch (alt13) {
>>>>>>> refs/remotes/origin/PeterWork
                case 1 :
<<<<<<< HEAD
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2286:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
=======
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2081:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
>>>>>>> refs/remotes/origin/PeterWork
                    {
                    match('\"'); 
<<<<<<< HEAD
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2286:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop30:
=======
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2081:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop11:
>>>>>>> refs/remotes/origin/PeterWork
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
<<<<<<< HEAD
                    	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2286:21: '\\\\' .
=======
                    	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2081:21: '\\\\' .
>>>>>>> refs/remotes/origin/PeterWork
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
<<<<<<< HEAD
                    	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2286:28: ~ ( ( '\\\\' | '\"' ) )
=======
                    	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2081:28: ~ ( ( '\\\\' | '\"' ) )
>>>>>>> refs/remotes/origin/PeterWork
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
<<<<<<< HEAD
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2286:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
=======
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2081:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
>>>>>>> refs/remotes/origin/PeterWork
                    {
                    match('\''); 
<<<<<<< HEAD
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2286:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop31:
=======
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2081:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop12:
>>>>>>> refs/remotes/origin/PeterWork
                    do {
<<<<<<< HEAD
                        int alt31=3;
                        int LA31_0 = input.LA(1);
=======
                        int alt12=3;
                        int LA12_0 = input.LA(1);
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        if ( (LA31_0=='\\') ) {
                            alt31=1;
=======
                        if ( (LA12_0=='\\') ) {
                            alt12=1;
>>>>>>> refs/remotes/origin/PeterWork
                        }
<<<<<<< HEAD
                        else if ( ((LA31_0>='\u0000' && LA31_0<='&')||(LA31_0>='(' && LA31_0<='[')||(LA31_0>=']' && LA31_0<='\uFFFF')) ) {
                            alt31=2;
=======
                        else if ( ((LA12_0>='\u0000' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\uFFFF')) ) {
                            alt12=2;
>>>>>>> refs/remotes/origin/PeterWork
                        }


<<<<<<< HEAD
                        switch (alt31) {
=======
                        switch (alt12) {
>>>>>>> refs/remotes/origin/PeterWork
                    	case 1 :
<<<<<<< HEAD
                    	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2286:54: '\\\\' .
=======
                    	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2081:54: '\\\\' .
>>>>>>> refs/remotes/origin/PeterWork
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
<<<<<<< HEAD
                    	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2286:61: ~ ( ( '\\\\' | '\\'' ) )
=======
                    	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2081:61: ~ ( ( '\\\\' | '\\'' ) )
>>>>>>> refs/remotes/origin/PeterWork
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
<<<<<<< HEAD
                    	    break loop31;
=======
                    	    break loop12;
>>>>>>> refs/remotes/origin/PeterWork
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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2288:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2288:19: '/*' ( options {greedy=false; } : . )* '*/'
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2083:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2083:19: '/*' ( options {greedy=false; } : . )* '*/'
>>>>>>> refs/remotes/origin/PeterWork
            {
            match("/*"); 

<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2288:24: ( options {greedy=false; } : . )*
            loop33:
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2083:24: ( options {greedy=false; } : . )*
            loop14:
>>>>>>> refs/remotes/origin/PeterWork
            do {
<<<<<<< HEAD
                int alt33=2;
                int LA33_0 = input.LA(1);
=======
                int alt14=2;
                int LA14_0 = input.LA(1);
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                if ( (LA33_0=='*') ) {
                    int LA33_1 = input.LA(2);
=======
                if ( (LA14_0=='*') ) {
                    int LA14_1 = input.LA(2);
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                    if ( (LA33_1=='/') ) {
                        alt33=2;
=======
                    if ( (LA14_1=='/') ) {
                        alt14=2;
>>>>>>> refs/remotes/origin/PeterWork
                    }
<<<<<<< HEAD
                    else if ( ((LA33_1>='\u0000' && LA33_1<='.')||(LA33_1>='0' && LA33_1<='\uFFFF')) ) {
                        alt33=1;
=======
                    else if ( ((LA14_1>='\u0000' && LA14_1<='.')||(LA14_1>='0' && LA14_1<='\uFFFF')) ) {
                        alt14=1;
>>>>>>> refs/remotes/origin/PeterWork
                    }


                }
<<<<<<< HEAD
                else if ( ((LA33_0>='\u0000' && LA33_0<=')')||(LA33_0>='+' && LA33_0<='\uFFFF')) ) {
                    alt33=1;
=======
                else if ( ((LA14_0>='\u0000' && LA14_0<=')')||(LA14_0>='+' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
>>>>>>> refs/remotes/origin/PeterWork
                }


<<<<<<< HEAD
                switch (alt33) {
=======
                switch (alt14) {
>>>>>>> refs/remotes/origin/PeterWork
            	case 1 :
<<<<<<< HEAD
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2288:52: .
=======
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2083:52: .
>>>>>>> refs/remotes/origin/PeterWork
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
<<<<<<< HEAD
            	    break loop33;
=======
            	    break loop14;
>>>>>>> refs/remotes/origin/PeterWork
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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2290:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2290:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2085:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2085:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
>>>>>>> refs/remotes/origin/PeterWork
            {
            match("//"); 

<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2290:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop34:
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2085:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop15:
>>>>>>> refs/remotes/origin/PeterWork
            do {
<<<<<<< HEAD
                int alt34=2;
                int LA34_0 = input.LA(1);
=======
                int alt15=2;
                int LA15_0 = input.LA(1);
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                if ( ((LA34_0>='\u0000' && LA34_0<='\t')||(LA34_0>='\u000B' && LA34_0<='\f')||(LA34_0>='\u000E' && LA34_0<='\uFFFF')) ) {
                    alt34=1;
=======
                if ( ((LA15_0>='\u0000' && LA15_0<='\t')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\uFFFF')) ) {
                    alt15=1;
>>>>>>> refs/remotes/origin/PeterWork
                }


<<<<<<< HEAD
                switch (alt34) {
=======
                switch (alt15) {
>>>>>>> refs/remotes/origin/PeterWork
            	case 1 :
<<<<<<< HEAD
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2290:24: ~ ( ( '\\n' | '\\r' ) )
=======
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2085:24: ~ ( ( '\\n' | '\\r' ) )
>>>>>>> refs/remotes/origin/PeterWork
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
<<<<<<< HEAD
            	    break loop34;
=======
            	    break loop15;
>>>>>>> refs/remotes/origin/PeterWork
                }
            } while (true);

<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2290:40: ( ( '\\r' )? '\\n' )?
            int alt36=2;
            int LA36_0 = input.LA(1);
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2085:40: ( ( '\\r' )? '\\n' )?
            int alt17=2;
            int LA17_0 = input.LA(1);
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
            if ( (LA36_0=='\n'||LA36_0=='\r') ) {
                alt36=1;
=======
            if ( (LA17_0=='\n'||LA17_0=='\r') ) {
                alt17=1;
>>>>>>> refs/remotes/origin/PeterWork
            }
<<<<<<< HEAD
            switch (alt36) {
=======
            switch (alt17) {
>>>>>>> refs/remotes/origin/PeterWork
                case 1 :
<<<<<<< HEAD
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2290:41: ( '\\r' )? '\\n'
=======
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2085:41: ( '\\r' )? '\\n'
>>>>>>> refs/remotes/origin/PeterWork
                    {
<<<<<<< HEAD
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2290:41: ( '\\r' )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);
=======
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2085:41: ( '\\r' )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                    if ( (LA35_0=='\r') ) {
                        alt35=1;
=======
                    if ( (LA16_0=='\r') ) {
                        alt16=1;
>>>>>>> refs/remotes/origin/PeterWork
                    }
<<<<<<< HEAD
                    switch (alt35) {
=======
                    switch (alt16) {
>>>>>>> refs/remotes/origin/PeterWork
                        case 1 :
<<<<<<< HEAD
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2290:41: '\\r'
=======
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2085:41: '\\r'
>>>>>>> refs/remotes/origin/PeterWork
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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2292:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2292:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2087:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2087:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
>>>>>>> refs/remotes/origin/PeterWork
            {
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2292:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt37=0;
            loop37:
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2087:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt18=0;
            loop18:
>>>>>>> refs/remotes/origin/PeterWork
            do {
<<<<<<< HEAD
                int alt37=2;
                int LA37_0 = input.LA(1);
=======
                int alt18=2;
                int LA18_0 = input.LA(1);
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                if ( ((LA37_0>='\t' && LA37_0<='\n')||LA37_0=='\r'||LA37_0==' ') ) {
                    alt37=1;
=======
                if ( ((LA18_0>='\t' && LA18_0<='\n')||LA18_0=='\r'||LA18_0==' ') ) {
                    alt18=1;
>>>>>>> refs/remotes/origin/PeterWork
                }


<<<<<<< HEAD
                switch (alt37) {
=======
                switch (alt18) {
>>>>>>> refs/remotes/origin/PeterWork
            	case 1 :
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:
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
<<<<<<< HEAD
            	    if ( cnt37 >= 1 ) break loop37;
=======
            	    if ( cnt18 >= 1 ) break loop18;
>>>>>>> refs/remotes/origin/PeterWork
                        EarlyExitException eee =
<<<<<<< HEAD
                            new EarlyExitException(37, input);
=======
                            new EarlyExitException(18, input);
>>>>>>> refs/remotes/origin/PeterWork
                        throw eee;
                }
<<<<<<< HEAD
                cnt37++;
=======
                cnt18++;
>>>>>>> refs/remotes/origin/PeterWork
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
<<<<<<< HEAD
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2294:16: ( . )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2294:18: .
=======
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2089:16: ( . )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2089:18: .
>>>>>>> refs/remotes/origin/PeterWork
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
<<<<<<< HEAD
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:8: ( T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | RULE_REAL_LIT | RULE_INTEGER_LIT | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt38=50;
        alt38 = dfa38.predict(input);
        switch (alt38) {
=======
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt19=48;
        alt19 = dfa19.predict(input);
        switch (alt19) {
>>>>>>> refs/remotes/origin/PeterWork
            case 1 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:10: T__20
                {
                mT__20(); 

                }
                break;
            case 2 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:16: T__21
                {
                mT__21(); 

                }
                break;
            case 3 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:22: T__22
                {
                mT__22(); 

                }
                break;
            case 4 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:28: T__23
                {
                mT__23(); 

                }
                break;
            case 5 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:34: T__24
                {
                mT__24(); 

                }
                break;
            case 6 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:40: T__25
                {
                mT__25(); 

                }
                break;
            case 7 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:46: T__26
                {
                mT__26(); 

                }
                break;
            case 8 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:52: T__27
                {
                mT__27(); 

                }
                break;
            case 9 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:58: T__28
                {
                mT__28(); 

                }
                break;
            case 10 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:64: T__29
                {
                mT__29(); 

                }
                break;
            case 11 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:70: T__30
                {
                mT__30(); 

                }
                break;
            case 12 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:76: T__31
                {
                mT__31(); 

                }
                break;
            case 13 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:82: T__32
                {
                mT__32(); 

                }
                break;
            case 14 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:88: T__33
                {
                mT__33(); 

                }
                break;
            case 15 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:94: T__34
                {
                mT__34(); 

                }
                break;
            case 16 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:100: T__35
                {
                mT__35(); 

                }
                break;
            case 17 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:106: T__36
                {
                mT__36(); 

                }
                break;
            case 18 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:112: T__37
                {
                mT__37(); 

                }
                break;
            case 19 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:118: T__38
                {
                mT__38(); 

                }
                break;
            case 20 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:124: T__39
                {
                mT__39(); 

                }
                break;
            case 21 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:130: T__40
                {
                mT__40(); 

                }
                break;
            case 22 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:136: T__41
                {
                mT__41(); 

                }
                break;
            case 23 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:142: T__42
                {
                mT__42(); 

                }
                break;
            case 24 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:148: T__43
                {
                mT__43(); 

                }
                break;
            case 25 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:154: T__44
                {
                mT__44(); 

                }
                break;
            case 26 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:160: T__45
                {
                mT__45(); 

                }
                break;
            case 27 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:166: T__46
                {
                mT__46(); 

                }
                break;
            case 28 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:172: T__47
                {
                mT__47(); 

                }
                break;
            case 29 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:178: T__48
                {
                mT__48(); 

                }
                break;
            case 30 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:184: T__49
                {
                mT__49(); 

                }
                break;
            case 31 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:190: T__50
                {
                mT__50(); 

                }
                break;
            case 32 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:196: T__51
                {
                mT__51(); 

                }
                break;
<<<<<<< HEAD
            case 33 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:202: T__52
                {
                mT__52(); 

                }
                break;
            case 34 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:208: T__53
                {
                mT__53(); 

                }
                break;
            case 35 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:214: T__54
                {
                mT__54(); 

                }
                break;
            case 36 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:220: T__55
                {
                mT__55(); 

                }
                break;
            case 37 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:226: T__56
                {
                mT__56(); 

                }
                break;
            case 38 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:232: T__57
                {
                mT__57(); 

                }
                break;
            case 39 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:238: T__58
                {
                mT__58(); 

                }
                break;
            case 40 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:244: RULE_REAL_LIT
                {
                mRULE_REAL_LIT(); 

                }
                break;
            case 41 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:258: RULE_INTEGER_LIT
                {
                mRULE_INTEGER_LIT(); 

                }
                break;
            case 42 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:275: RULE_HEX
=======
            case 40 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:244: RULE_HEX
>>>>>>> refs/remotes/origin/PeterWork
                {
                mRULE_HEX(); 

                }
                break;
<<<<<<< HEAD
            case 43 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:284: RULE_INT
=======
            case 41 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:253: RULE_INT
>>>>>>> refs/remotes/origin/PeterWork
                {
                mRULE_INT(); 

                }
                break;
<<<<<<< HEAD
            case 44 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:293: RULE_DECIMAL
=======
            case 42 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:262: RULE_DECIMAL
>>>>>>> refs/remotes/origin/PeterWork
                {
                mRULE_DECIMAL(); 

                }
                break;
<<<<<<< HEAD
            case 45 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:306: RULE_ID
=======
            case 43 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:275: RULE_ID
>>>>>>> refs/remotes/origin/PeterWork
                {
                mRULE_ID(); 

                }
                break;
<<<<<<< HEAD
            case 46 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:314: RULE_STRING
=======
            case 44 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:283: RULE_STRING
>>>>>>> refs/remotes/origin/PeterWork
                {
                mRULE_STRING(); 

                }
                break;
<<<<<<< HEAD
            case 47 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:326: RULE_ML_COMMENT
=======
            case 45 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:295: RULE_ML_COMMENT
>>>>>>> refs/remotes/origin/PeterWork
                {
                mRULE_ML_COMMENT(); 

                }
                break;
<<<<<<< HEAD
            case 48 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:342: RULE_SL_COMMENT
=======
            case 46 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:311: RULE_SL_COMMENT
>>>>>>> refs/remotes/origin/PeterWork
                {
                mRULE_SL_COMMENT(); 

                }
                break;
<<<<<<< HEAD
            case 49 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:358: RULE_WS
=======
            case 47 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:327: RULE_WS
>>>>>>> refs/remotes/origin/PeterWork
                {
                mRULE_WS(); 

                }
                break;
<<<<<<< HEAD
            case 50 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:366: RULE_ANY_OTHER
=======
            case 48 :
                // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1:335: RULE_ANY_OTHER
>>>>>>> refs/remotes/origin/PeterWork
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


<<<<<<< HEAD
    protected DFA38 dfa38 = new DFA38(this);
    static final String DFA38_eotS =
        "\1\uffff\2\45\1\uffff\1\45\1\54\1\56\2\43\1\63\1\65\1\67\1\71\1"+
        "\73\1\43\1\uffff\1\77\10\uffff\2\45\1\43\2\115\1\43\1\uffff\2\43"+
        "\2\uffff\1\45\1\uffff\2\45\1\uffff\1\45\3\uffff\1\131\3\uffff\1"+
        "\133\2\uffff\1\135\23\uffff\2\45\2\uffff\1\140\3\uffff\1\115\3\uffff"+
        "\3\45\1\150\6\uffff\2\45\1\uffff\1\115\1\140\1\uffff\1\115\1\45"+
        "\1\155\1\156\1\uffff\1\45\1\160\1\115\1\45\2\uffff\1\162\1\uffff"+
        "\1\45\1\uffff\4\45\1\170\1\uffff";
    static final String DFA38_eofS =
        "\171\uffff";
    static final String DFA38_minS =
        "\1\0\1\145\1\150\1\uffff\1\155\1\52\1\56\1\174\1\46\3\75\2\76\1"+
        "\72\1\uffff\1\52\10\uffff\1\141\1\165\1\72\2\56\1\101\1\uffff\2"+
        "\0\2\uffff\1\163\1\uffff\1\151\1\165\1\uffff\1\147\3\uffff\1\74"+
        "\3\uffff\1\75\2\uffff\1\75\23\uffff\2\154\2\uffff\1\60\1\uffff\1"+
        "\53\1\uffff\1\56\3\uffff\1\143\1\163\1\145\1\60\6\uffff\1\163\1"+
        "\154\1\uffff\1\56\3\60\1\162\2\60\1\uffff\1\145\2\60\1\151\2\uffff"+
        "\1\60\1\uffff\1\160\1\uffff\1\164\1\151\1\157\1\156\1\60\1\uffff";
    static final String DFA38_maxS =
        "\1\uffff\1\145\1\162\1\uffff\1\155\1\57\1\56\1\174\1\46\1\76\2"+
        "\75\2\76\1\72\1\uffff\1\52\10\uffff\1\141\1\165\1\72\1\170\1\154"+
        "\1\172\1\uffff\2\uffff\2\uffff\1\163\1\uffff\1\151\1\165\1\uffff"+
        "\1\147\3\uffff\1\74\3\uffff\1\75\2\uffff\1\75\23\uffff\2\154\2\uffff"+
        "\1\154\1\uffff\1\71\1\uffff\1\154\3\uffff\1\143\1\163\1\145\1\172"+
        "\6\uffff\1\163\1\154\1\uffff\2\154\1\71\1\154\1\162\2\172\1\uffff"+
        "\1\145\1\172\1\154\1\151\2\uffff\1\172\1\uffff\1\160\1\uffff\1\164"+
        "\1\151\1\157\1\156\1\172\1\uffff";
    static final String DFA38_acceptS =
        "\3\uffff\1\3\13\uffff\1\27\1\uffff\1\34\1\35\1\36\1\37\1\40\1\41"+
        "\1\42\1\43\6\uffff\1\55\2\uffff\1\61\1\62\1\uffff\1\55\2\uffff\1"+
        "\3\1\uffff\1\57\1\60\1\5\1\uffff\1\6\1\7\1\10\1\uffff\1\24\1\17"+
        "\1\uffff\1\33\1\15\1\20\1\25\1\16\1\21\1\30\1\26\1\27\1\32\1\31"+
        "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\2\uffff\1\47\1\52\1\uffff"+
        "\1\51\1\uffff\1\54\1\uffff\1\50\1\56\1\61\4\uffff\1\22\1\23\1\13"+
        "\1\11\1\14\1\12\2\uffff\1\53\7\uffff\1\4\4\uffff\1\2\1\44\1\uffff"+
        "\1\46\1\uffff\1\45\5\uffff\1\1";
    static final String DFA38_specialS =
        "\1\0\37\uffff\1\2\1\1\127\uffff}>";
    static final String[] DFA38_transitionS = {
            "\11\43\2\42\2\43\1\42\22\43\1\42\1\12\1\40\1\24\1\43\1\3\1"+
            "\10\1\41\1\27\1\30\1\20\1\17\1\22\1\15\1\6\1\5\1\34\11\35\1"+
            "\33\1\43\1\14\1\11\1\13\1\16\1\43\32\37\1\25\1\43\1\26\1\36"+
            "\1\37\1\43\3\37\1\1\1\37\1\31\2\37\1\4\4\37\1\32\5\37\1\2\6"+
            "\37\1\21\1\7\1\23\uff82\43",
            "\1\44",
            "\1\46\11\uffff\1\47",
            "",
            "\1\51",
            "\1\52\4\uffff\1\53",
            "\1\55",
            "\1\57",
            "\1\60",
            "\1\61\1\62",
            "\1\64",
            "\1\66",
            "\1\70",
            "\1\72",
            "\1\74",
            "",
            "\1\76",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\121\1\uffff\12\120\10\uffff\1\117\1\uffff\1\117\1\116\1"+
            "\117\5\uffff\1\117\13\uffff\1\113\6\uffff\1\114\2\uffff\1\117"+
            "\1\uffff\1\117\1\116\1\117\5\uffff\1\117\13\uffff\1\113",
            "\1\121\1\uffff\12\120\10\uffff\1\117\1\uffff\1\117\1\116\1"+
            "\117\5\uffff\1\117\22\uffff\1\114\2\uffff\1\117\1\uffff\1\117"+
            "\1\116\1\117\5\uffff\1\117",
            "\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\0\122",
            "\0\122",
            "",
=======
    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA19_eotS =
        "\1\uffff\2\45\1\uffff\1\45\1\54\1\56\2\43\1\63\1\65\1\67\1\71\1"+
        "\73\1\43\1\uffff\1\77\10\uffff\2\45\1\43\2\115\1\43\1\uffff\2\43"+
        "\2\uffff\1\45\1\uffff\2\45\1\uffff\1\45\3\uffff\1\126\3\uffff\1"+
        "\130\2\uffff\1\132\23\uffff\2\45\2\uffff\1\115\4\uffff\3\45\1\140"+
        "\6\uffff\3\45\1\144\1\145\1\uffff\1\45\1\147\1\45\2\uffff\1\151"+
        "\1\uffff\1\45\1\uffff\4\45\1\157\1\uffff";
    static final String DFA19_eofS =
        "\160\uffff";
    static final String DFA19_minS =
        "\1\0\1\145\1\150\1\uffff\1\155\1\52\1\56\1\174\1\46\3\75\2\76\1"+
        "\72\1\uffff\1\52\10\uffff\1\141\1\165\1\72\2\60\1\101\1\uffff\2"+
        "\0\2\uffff\1\163\1\uffff\1\151\1\165\1\uffff\1\147\3\uffff\1\74"+
        "\3\uffff\1\75\2\uffff\1\75\23\uffff\2\154\2\uffff\1\60\4\uffff\1"+
        "\143\1\163\1\145\1\60\6\uffff\1\163\1\154\1\162\2\60\1\uffff\1\145"+
        "\1\60\1\151\2\uffff\1\60\1\uffff\1\160\1\uffff\1\164\1\151\1\157"+
        "\1\156\1\60\1\uffff";
    static final String DFA19_maxS =
        "\1\uffff\1\145\1\162\1\uffff\1\155\1\57\1\56\1\174\1\46\1\76\2"+
        "\75\2\76\1\72\1\uffff\1\52\10\uffff\1\141\1\165\1\72\1\170\1\154"+
        "\1\172\1\uffff\2\uffff\2\uffff\1\163\1\uffff\1\151\1\165\1\uffff"+
        "\1\147\3\uffff\1\74\3\uffff\1\75\2\uffff\1\75\23\uffff\2\154\2\uffff"+
        "\1\154\4\uffff\1\143\1\163\1\145\1\172\6\uffff\1\163\1\154\1\162"+
        "\2\172\1\uffff\1\145\1\172\1\151\2\uffff\1\172\1\uffff\1\160\1\uffff"+
        "\1\164\1\151\1\157\1\156\1\172\1\uffff";
    static final String DFA19_acceptS =
        "\3\uffff\1\3\13\uffff\1\27\1\uffff\1\34\1\35\1\36\1\37\1\40\1\41"+
        "\1\42\1\43\6\uffff\1\53\2\uffff\1\57\1\60\1\uffff\1\53\2\uffff\1"+
        "\3\1\uffff\1\55\1\56\1\5\1\uffff\1\6\1\7\1\10\1\uffff\1\24\1\17"+
        "\1\uffff\1\33\1\15\1\20\1\25\1\16\1\21\1\30\1\26\1\27\1\32\1\31"+
        "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\2\uffff\1\47\1\50\1\uffff"+
        "\1\51\1\52\1\54\1\57\4\uffff\1\22\1\23\1\13\1\11\1\14\1\12\5\uffff"+
        "\1\4\3\uffff\1\2\1\45\1\uffff\1\46\1\uffff\1\44\5\uffff\1\1";
    static final String DFA19_specialS =
        "\1\1\37\uffff\1\2\1\0\116\uffff}>";
    static final String[] DFA19_transitionS = {
            "\11\43\2\42\2\43\1\42\22\43\1\42\1\12\1\40\1\21\1\43\1\3\1"+
            "\10\1\41\1\27\1\30\1\20\1\17\1\23\1\15\1\6\1\5\1\34\11\35\1"+
            "\33\1\43\1\14\1\11\1\13\1\16\1\43\32\37\1\25\1\43\1\26\1\36"+
            "\1\37\1\43\3\37\1\1\1\37\1\31\2\37\1\4\4\37\1\32\5\37\1\2\6"+
            "\37\1\22\1\7\1\24\uff82\43",
            "\1\44",
            "\1\46\11\uffff\1\47",
            "",
            "\1\51",
            "\1\52\4\uffff\1\53",
            "\1\55",
            "\1\57",
            "\1\60",
            "\1\61\1\62",
            "\1\64",
            "\1\66",
            "\1\70",
            "\1\72",
            "\1\74",
            "",
            "\1\76",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\110",
            "\1\111",
            "\1\112",
            "\12\114\10\uffff\1\116\1\uffff\3\116\5\uffff\1\116\13\uffff"+
            "\1\113\6\uffff\1\114\2\uffff\1\116\1\uffff\3\116\5\uffff\1\116"+
            "\13\uffff\1\113",
            "\12\114\10\uffff\1\116\1\uffff\3\116\5\uffff\1\116\22\uffff"+
            "\1\114\2\uffff\1\116\1\uffff\3\116\5\uffff\1\116",
            "\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\0\117",
            "\0\117",
            "",
            "",
            "\1\121",
            "",
            "\1\122",
            "\1\123",
>>>>>>> refs/remotes/origin/PeterWork
            "",
            "\1\124",
            "",
<<<<<<< HEAD
            "\1\125",
            "\1\126",
            "",
            "\1\127",
            "",
            "",
            "",
            "\1\130",
            "",
            "",
            "",
            "\1\132",
            "",
            "",
            "\1\134",
=======
            "",
            "",
            "\1\125",
            "",
            "",
            "",
            "\1\127",
            "",
            "",
            "\1\131",
>>>>>>> refs/remotes/origin/PeterWork
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
<<<<<<< HEAD
            "\1\136",
            "\1\137",
            "",
            "",
            "\12\141\10\uffff\1\117\1\uffff\3\117\5\uffff\1\117\22\uffff"+
            "\1\142\2\uffff\1\117\1\uffff\3\117\5\uffff\1\117",
            "",
            "\1\143\1\uffff\1\117\2\uffff\12\144",
            "",
            "\1\121\1\uffff\12\120\10\uffff\1\117\1\uffff\1\117\1\116\1"+
            "\117\5\uffff\1\117\22\uffff\1\114\2\uffff\1\117\1\uffff\1\117"+
            "\1\116\1\117\5\uffff\1\117",
            "",
            "",
            "",
            "\1\145",
            "\1\146",
            "\1\147",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\151",
            "\1\152",
            "",
            "\1\121\1\uffff\12\141\10\uffff\1\117\1\uffff\1\117\1\116\1"+
            "\117\5\uffff\1\117\22\uffff\1\114\2\uffff\1\117\1\uffff\1\117"+
            "\1\116\1\117\5\uffff\1\117",
            "\12\142\10\uffff\1\117\1\uffff\3\117\5\uffff\1\117\22\uffff"+
            "\1\142\2\uffff\1\117\1\uffff\3\117\5\uffff\1\117",
            "\12\144",
            "\12\153\10\uffff\1\117\1\uffff\1\117\1\uffff\1\117\5\uffff"+
            "\1\117\22\uffff\1\117\2\uffff\1\117\1\uffff\1\117\1\uffff\1"+
            "\117\5\uffff\1\117",
            "\1\154",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\157",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\153\10\uffff\1\117\1\uffff\1\117\1\uffff\1\117\5\uffff"+
            "\1\117\22\uffff\1\117\2\uffff\1\117\1\uffff\1\117\1\uffff\1"+
            "\117\5\uffff\1\117",
            "\1\161",
            "",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\163",
            "",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
=======
            "\1\133",
            "\1\134",
            "",
            "",
            "\12\114\10\uffff\1\116\1\uffff\3\116\5\uffff\1\116\22\uffff"+
            "\1\114\2\uffff\1\116\1\uffff\3\116\5\uffff\1\116",
            "",
            "",
            "",
            "",
            "\1\135",
            "\1\136",
            "\1\137",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\141",
            "\1\142",
            "\1\143",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\146",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\150",
            "",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\152",
            "",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
>>>>>>> refs/remotes/origin/PeterWork
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            ""
    };

<<<<<<< HEAD
    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;
=======
    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;
>>>>>>> refs/remotes/origin/PeterWork

    static {
<<<<<<< HEAD
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
=======
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
>>>>>>> refs/remotes/origin/PeterWork
        for (int i=0; i<numStates; i++) {
<<<<<<< HEAD
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
=======
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
>>>>>>> refs/remotes/origin/PeterWork
        }
    }

<<<<<<< HEAD
    class DFA38 extends DFA {
=======
    class DFA19 extends DFA {
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
        public DFA38(BaseRecognizer recognizer) {
=======
        public DFA19(BaseRecognizer recognizer) {
>>>>>>> refs/remotes/origin/PeterWork
            this.recognizer = recognizer;
<<<<<<< HEAD
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
=======
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
>>>>>>> refs/remotes/origin/PeterWork
        }
        public String getDescription() {
<<<<<<< HEAD
            return "1:1: Tokens : ( T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | RULE_REAL_LIT | RULE_INTEGER_LIT | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
=======
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
>>>>>>> refs/remotes/origin/PeterWork
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
<<<<<<< HEAD
                        int LA38_0 = input.LA(1);
=======
                        int LA19_33 = input.LA(1);
>>>>>>> refs/remotes/origin/PeterWork

                        s = -1;
<<<<<<< HEAD
                        if ( (LA38_0=='d') ) {s = 1;}
=======
                        if ( ((LA19_33>='\u0000' && LA19_33<='\uFFFF')) ) {s = 79;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='t') ) {s = 2;}
=======
                        else s = 35;
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='%') ) {s = 3;}
=======
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA19_0 = input.LA(1);
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='i') ) {s = 4;}
=======
                        s = -1;
                        if ( (LA19_0=='d') ) {s = 1;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='/') ) {s = 5;}
=======
                        else if ( (LA19_0=='t') ) {s = 2;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='.') ) {s = 6;}
=======
                        else if ( (LA19_0=='%') ) {s = 3;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='|') ) {s = 7;}
=======
                        else if ( (LA19_0=='i') ) {s = 4;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='&') ) {s = 8;}
=======
                        else if ( (LA19_0=='/') ) {s = 5;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='=') ) {s = 9;}
=======
                        else if ( (LA19_0=='.') ) {s = 6;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='!') ) {s = 10;}
=======
                        else if ( (LA19_0=='|') ) {s = 7;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='>') ) {s = 11;}
=======
                        else if ( (LA19_0=='&') ) {s = 8;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='<') ) {s = 12;}
=======
                        else if ( (LA19_0=='=') ) {s = 9;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='-') ) {s = 13;}
=======
                        else if ( (LA19_0=='!') ) {s = 10;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='?') ) {s = 14;}
=======
                        else if ( (LA19_0=='>') ) {s = 11;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='+') ) {s = 15;}
=======
                        else if ( (LA19_0=='<') ) {s = 12;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='*') ) {s = 16;}
=======
                        else if ( (LA19_0=='-') ) {s = 13;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='{') ) {s = 17;}
=======
                        else if ( (LA19_0=='?') ) {s = 14;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0==',') ) {s = 18;}
=======
                        else if ( (LA19_0=='+') ) {s = 15;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='}') ) {s = 19;}
=======
                        else if ( (LA19_0=='*') ) {s = 16;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='#') ) {s = 20;}
=======
                        else if ( (LA19_0=='#') ) {s = 17;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='[') ) {s = 21;}
=======
                        else if ( (LA19_0=='{') ) {s = 18;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0==']') ) {s = 22;}
=======
                        else if ( (LA19_0==',') ) {s = 19;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='(') ) {s = 23;}
=======
                        else if ( (LA19_0=='}') ) {s = 20;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0==')') ) {s = 24;}
=======
                        else if ( (LA19_0=='[') ) {s = 21;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='f') ) {s = 25;}
=======
                        else if ( (LA19_0==']') ) {s = 22;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='n') ) {s = 26;}
=======
                        else if ( (LA19_0=='(') ) {s = 23;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0==':') ) {s = 27;}
=======
                        else if ( (LA19_0==')') ) {s = 24;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='0') ) {s = 28;}
=======
                        else if ( (LA19_0=='f') ) {s = 25;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( ((LA38_0>='1' && LA38_0<='9')) ) {s = 29;}
=======
                        else if ( (LA19_0=='n') ) {s = 26;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='^') ) {s = 30;}
=======
                        else if ( (LA19_0==':') ) {s = 27;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( ((LA38_0>='A' && LA38_0<='Z')||LA38_0=='_'||(LA38_0>='a' && LA38_0<='c')||LA38_0=='e'||(LA38_0>='g' && LA38_0<='h')||(LA38_0>='j' && LA38_0<='m')||(LA38_0>='o' && LA38_0<='s')||(LA38_0>='u' && LA38_0<='z')) ) {s = 31;}
=======
                        else if ( (LA19_0=='0') ) {s = 28;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='\"') ) {s = 32;}
=======
                        else if ( ((LA19_0>='1' && LA19_0<='9')) ) {s = 29;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( (LA38_0=='\'') ) {s = 33;}
=======
                        else if ( (LA19_0=='^') ) {s = 30;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( ((LA38_0>='\t' && LA38_0<='\n')||LA38_0=='\r'||LA38_0==' ') ) {s = 34;}
=======
                        else if ( ((LA19_0>='A' && LA19_0<='Z')||LA19_0=='_'||(LA19_0>='a' && LA19_0<='c')||LA19_0=='e'||(LA19_0>='g' && LA19_0<='h')||(LA19_0>='j' && LA19_0<='m')||(LA19_0>='o' && LA19_0<='s')||(LA19_0>='u' && LA19_0<='z')) ) {s = 31;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else if ( ((LA38_0>='\u0000' && LA38_0<='\b')||(LA38_0>='\u000B' && LA38_0<='\f')||(LA38_0>='\u000E' && LA38_0<='\u001F')||LA38_0=='$'||LA38_0==';'||LA38_0=='@'||LA38_0=='\\'||LA38_0=='`'||(LA38_0>='~' && LA38_0<='\uFFFF')) ) {s = 35;}
=======
                        else if ( (LA19_0=='\"') ) {s = 32;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA38_33 = input.LA(1);
=======
                        else if ( (LA19_0=='\'') ) {s = 33;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        s = -1;
                        if ( ((LA38_33>='\u0000' && LA38_33<='\uFFFF')) ) {s = 82;}
=======
                        else if ( ((LA19_0>='\t' && LA19_0<='\n')||LA19_0=='\r'||LA19_0==' ') ) {s = 34;}
>>>>>>> refs/remotes/origin/PeterWork

<<<<<<< HEAD
                        else s = 35;
=======
                        else if ( ((LA19_0>='\u0000' && LA19_0<='\b')||(LA19_0>='\u000B' && LA19_0<='\f')||(LA19_0>='\u000E' && LA19_0<='\u001F')||LA19_0=='$'||LA19_0==';'||LA19_0=='@'||LA19_0=='\\'||LA19_0=='`'||(LA19_0>='~' && LA19_0<='\uFFFF')) ) {s = 35;}
>>>>>>> refs/remotes/origin/PeterWork

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
<<<<<<< HEAD
                        int LA38_32 = input.LA(1);
=======
                        int LA19_32 = input.LA(1);
>>>>>>> refs/remotes/origin/PeterWork

                        s = -1;
<<<<<<< HEAD
                        if ( ((LA38_32>='\u0000' && LA38_32<='\uFFFF')) ) {s = 82;}
=======
                        if ( ((LA19_32>='\u0000' && LA19_32<='\uFFFF')) ) {s = 79;}
>>>>>>> refs/remotes/origin/PeterWork

                        else s = 35;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
<<<<<<< HEAD
                new NoViableAltException(getDescription(), 38, _s, input);
=======
                new NoViableAltException(getDescription(), 19, _s, input);
>>>>>>> refs/remotes/origin/PeterWork
            error(nvae);
            throw nvae;
        }
    }
 

}