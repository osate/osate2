// $ANTLR 3.3 Nov 30, 2010 12:50:56 Lute.g 2012-04-27 09:31:42

  package org.osate.validation.lute;
  
  import java.util.Arrays;
  import java.math.BigInteger;


import org.antlr.runtime.*;
import org.osate.validation.Logger;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class LuteParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "STRING", "LETTER", "DIGIT", "SPECIAL", "WS", "COMMENT", "'theorem'", "'end'", "';'", "':='", "'('", "','", "')'", "'foreach'", "'in'", "'do'", "'check'", "'print'", "'if'", "'then'", "'else'", "'and'", "'or'", "'not'", "'='", "'>'", "'<'", "'>='", "'<='", "'!='", "'+'", "'-'", "'*'", "'{'", "'for'", "'|'", "'}'", "'true'", "'false'"
    };
    public static final int EOF=-1;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int ID=4;
    public static final int INT=5;
    public static final int STRING=6;
    public static final int LETTER=7;
    public static final int DIGIT=8;
    public static final int SPECIAL=9;
    public static final int WS=10;
    public static final int COMMENT=11;

    // delegates
    // delegators


        public LuteParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public LuteParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return LuteParser.tokenNames; }
    public String getGrammarFileName() { return "Lute.g"; }


      private Logger log;
      
      public LuteParser(TokenStream input, Logger log) {
        this(input);
        this.log = log;
      }
      
      @Override
      public void emitErrorMessage(String msg) {
        if (log != null) {
          log.error(msg);
        } else {
          super.emitErrorMessage(msg);
        }
      }

      protected void ignore(Stack<Void> stack, List<Void> list, ArrayList<Void> arraylist) {}



    // $ANTLR start "rule"
    // Lute.g:82:1: rule returns [List<Command> cmds] : ( command )* ;
    public final List<Command> rule() throws RecognitionException {
        List<Command> cmds = null;

        Command command1 = null;


        try {
            // Lute.g:83:3: ( ( command )* )
            // Lute.g:83:5: ( command )*
            {
             cmds = new ArrayList<Command>(); 
            // Lute.g:84:5: ( command )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID||LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Lute.g:84:6: command
            	    {
            	    pushFollow(FOLLOW_command_in_rule66);
            	    command1=command();

            	    state._fsp--;

            	     cmds.add(command1); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return cmds;
    }
    // $ANTLR end "rule"


    // $ANTLR start "command"
    // Lute.g:87:1: command returns [Command c] : ( 'theorem' ID stmt 'end' ';' | ID ':=' expr ';' | fn= ID '(' arg= ID ( ',' arg= ID )* ')' ':=' expr ';' );
    public final Command command() throws RecognitionException {
        Command c = null;

        Token fn=null;
        Token arg=null;
        Token ID2=null;
        Token ID4=null;
        Stmt stmt3 = null;

        Expr expr5 = null;

        Expr expr6 = null;


        try {
            // Lute.g:88:3: ( 'theorem' ID stmt 'end' ';' | ID ':=' expr ';' | fn= ID '(' arg= ID ( ',' arg= ID )* ')' ':=' expr ';' )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            else if ( (LA3_0==ID) ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==15) ) {
                    alt3=2;
                }
                else if ( (LA3_2==16) ) {
                    alt3=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // Lute.g:88:5: 'theorem' ID stmt 'end' ';'
                    {
                    match(input,12,FOLLOW_12_in_command87); 
                    ID2=(Token)match(input,ID,FOLLOW_ID_in_command89); 
                    pushFollow(FOLLOW_stmt_in_command91);
                    stmt3=stmt();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_command93); 
                    match(input,14,FOLLOW_14_in_command95); 
                     c = new Theorem((ID2!=null?ID2.getText():null), stmt3); 

                    }
                    break;
                case 2 :
                    // Lute.g:90:5: ID ':=' expr ';'
                    {
                    ID4=(Token)match(input,ID,FOLLOW_ID_in_command107); 
                    match(input,15,FOLLOW_15_in_command109); 
                    pushFollow(FOLLOW_expr_in_command111);
                    expr5=expr();

                    state._fsp--;

                    match(input,14,FOLLOW_14_in_command113); 
                     c = new Assignment((ID4!=null?ID4.getText():null), expr5); 

                    }
                    break;
                case 3 :
                    // Lute.g:92:5: fn= ID '(' arg= ID ( ',' arg= ID )* ')' ':=' expr ';'
                    {
                     ArrayList<String> args = new ArrayList<String>(); 
                    fn=(Token)match(input,ID,FOLLOW_ID_in_command133); 
                    match(input,16,FOLLOW_16_in_command135); 
                    arg=(Token)match(input,ID,FOLLOW_ID_in_command139); 
                     args.add((arg!=null?arg.getText():null)); 
                    // Lute.g:94:15: ( ',' arg= ID )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==17) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // Lute.g:94:16: ',' arg= ID
                    	    {
                    	    match(input,17,FOLLOW_17_in_command158); 
                    	    arg=(Token)match(input,ID,FOLLOW_ID_in_command162); 
                    	     args.add((arg!=null?arg.getText():null)); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    match(input,18,FOLLOW_18_in_command168); 
                    match(input,15,FOLLOW_15_in_command170); 
                    pushFollow(FOLLOW_expr_in_command172);
                    expr6=expr();

                    state._fsp--;

                    match(input,14,FOLLOW_14_in_command174); 
                     c = new FunctionDefinition((fn!=null?fn.getText():null), args, expr6); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return c;
    }
    // $ANTLR end "command"


    // $ANTLR start "stmt"
    // Lute.g:98:1: stmt returns [Stmt s] : ( 'foreach' ID 'in' expr 'do' body= stmt | 'check' expr ';' | ID ':=' expr ';' body= stmt | 'print' d= expr ( ',' d= expr )* ';' body= stmt );
    public final Stmt stmt() throws RecognitionException {
        Stmt s = null;

        Token ID7=null;
        Token ID10=null;
        Stmt body = null;

        Expr d = null;

        Expr expr8 = null;

        Expr expr9 = null;

        Expr expr11 = null;


        try {
            // Lute.g:99:3: ( 'foreach' ID 'in' expr 'do' body= stmt | 'check' expr ';' | ID ':=' expr ';' body= stmt | 'print' d= expr ( ',' d= expr )* ';' body= stmt )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt5=1;
                }
                break;
            case 22:
                {
                alt5=2;
                }
                break;
            case ID:
                {
                alt5=3;
                }
                break;
            case 23:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // Lute.g:99:5: 'foreach' ID 'in' expr 'do' body= stmt
                    {
                    match(input,19,FOLLOW_19_in_stmt197); 
                    ID7=(Token)match(input,ID,FOLLOW_ID_in_stmt199); 
                    match(input,20,FOLLOW_20_in_stmt201); 
                    pushFollow(FOLLOW_expr_in_stmt203);
                    expr8=expr();

                    state._fsp--;

                    match(input,21,FOLLOW_21_in_stmt205); 
                    pushFollow(FOLLOW_stmt_in_stmt209);
                    body=stmt();

                    state._fsp--;

                     s = new ForeachStmt((ID7!=null?ID7.getText():null), expr8, body); 

                    }
                    break;
                case 2 :
                    // Lute.g:101:5: 'check' expr ';'
                    {
                    match(input,22,FOLLOW_22_in_stmt221); 
                    pushFollow(FOLLOW_expr_in_stmt223);
                    expr9=expr();

                    state._fsp--;

                    match(input,14,FOLLOW_14_in_stmt225); 
                     s = new CheckStmt(expr9); 

                    }
                    break;
                case 3 :
                    // Lute.g:103:5: ID ':=' expr ';' body= stmt
                    {
                    ID10=(Token)match(input,ID,FOLLOW_ID_in_stmt237); 
                    match(input,15,FOLLOW_15_in_stmt239); 
                    pushFollow(FOLLOW_expr_in_stmt241);
                    expr11=expr();

                    state._fsp--;

                    match(input,14,FOLLOW_14_in_stmt243); 
                    pushFollow(FOLLOW_stmt_in_stmt247);
                    body=stmt();

                    state._fsp--;

                     s = new LetStmt((ID10!=null?ID10.getText():null), expr11, body); 

                    }
                    break;
                case 4 :
                    // Lute.g:105:5: 'print' d= expr ( ',' d= expr )* ';' body= stmt
                    {
                     ArrayList<Expr> exprs = new ArrayList<Expr>(); 
                    match(input,23,FOLLOW_23_in_stmt265); 
                    pushFollow(FOLLOW_expr_in_stmt269);
                    d=expr();

                    state._fsp--;

                     exprs.add(d); 
                    // Lute.g:107:7: ( ',' d= expr )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==17) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // Lute.g:107:8: ',' d= expr
                    	    {
                    	    match(input,17,FOLLOW_17_in_stmt280); 
                    	    pushFollow(FOLLOW_expr_in_stmt284);
                    	    d=expr();

                    	    state._fsp--;

                    	     exprs.add(d); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match(input,14,FOLLOW_14_in_stmt291); 
                    pushFollow(FOLLOW_stmt_in_stmt299);
                    body=stmt();

                    state._fsp--;

                     s = new PrintStmt(exprs, body); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "stmt"


    // $ANTLR start "expr"
    // Lute.g:112:1: expr returns [Expr e] : ( predicate | 'if' c= predicate 'then' t= predicate 'else' f= predicate );
    public final Expr expr() throws RecognitionException {
        Expr e = null;

        Expr c = null;

        Expr t = null;

        Expr f = null;

        Expr predicate12 = null;


        try {
            // Lute.g:113:3: ( predicate | 'if' c= predicate 'then' t= predicate 'else' f= predicate )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=ID && LA6_0<=STRING)||LA6_0==16||LA6_0==29||LA6_0==39||(LA6_0>=43 && LA6_0<=44)) ) {
                alt6=1;
            }
            else if ( (LA6_0==24) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // Lute.g:113:5: predicate
                    {
                    pushFollow(FOLLOW_predicate_in_expr322);
                    predicate12=predicate();

                    state._fsp--;

                     e = predicate12; 

                    }
                    break;
                case 2 :
                    // Lute.g:114:5: 'if' c= predicate 'then' t= predicate 'else' f= predicate
                    {
                    match(input,24,FOLLOW_24_in_expr330); 
                    pushFollow(FOLLOW_predicate_in_expr334);
                    c=predicate();

                    state._fsp--;

                    match(input,25,FOLLOW_25_in_expr336); 
                    pushFollow(FOLLOW_predicate_in_expr340);
                    t=predicate();

                    state._fsp--;

                    match(input,26,FOLLOW_26_in_expr342); 
                    pushFollow(FOLLOW_predicate_in_expr346);
                    f=predicate();

                    state._fsp--;

                     e = new IfExpr(c, t, f); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "expr"


    // $ANTLR start "predicate"
    // Lute.g:118:1: predicate returns [Expr e] : l= neg_predicate ( 'and' r= neg_predicate | 'or' r= neg_predicate )* ;
    public final Expr predicate() throws RecognitionException {
        Expr e = null;

        Expr l = null;

        Expr r = null;


        try {
            // Lute.g:119:3: (l= neg_predicate ( 'and' r= neg_predicate | 'or' r= neg_predicate )* )
            // Lute.g:119:5: l= neg_predicate ( 'and' r= neg_predicate | 'or' r= neg_predicate )*
            {
            pushFollow(FOLLOW_neg_predicate_in_predicate371);
            l=neg_predicate();

            state._fsp--;

             e = l; 
            // Lute.g:120:5: ( 'and' r= neg_predicate | 'or' r= neg_predicate )*
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==27) ) {
                    alt7=1;
                }
                else if ( (LA7_0==28) ) {
                    alt7=2;
                }


                switch (alt7) {
            	case 1 :
            	    // Lute.g:120:6: 'and' r= neg_predicate
            	    {
            	    match(input,27,FOLLOW_27_in_predicate380); 
            	    pushFollow(FOLLOW_neg_predicate_in_predicate384);
            	    r=neg_predicate();

            	    state._fsp--;

            	     e = new AndExpr(e, r); 

            	    }
            	    break;
            	case 2 :
            	    // Lute.g:121:6: 'or' r= neg_predicate
            	    {
            	    match(input,28,FOLLOW_28_in_predicate395); 
            	    pushFollow(FOLLOW_neg_predicate_in_predicate399);
            	    r=neg_predicate();

            	    state._fsp--;

            	     e = new OrExpr(e, r); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "predicate"


    // $ANTLR start "neg_predicate"
    // Lute.g:124:1: neg_predicate returns [Expr e] : ( 'not' n= neg_predicate | a= atomic_predicate );
    public final Expr neg_predicate() throws RecognitionException {
        Expr e = null;

        Expr n = null;

        Expr a = null;


        try {
            // Lute.g:125:3: ( 'not' n= neg_predicate | a= atomic_predicate )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==29) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=ID && LA8_0<=STRING)||LA8_0==16||LA8_0==39||(LA8_0>=43 && LA8_0<=44)) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // Lute.g:125:5: 'not' n= neg_predicate
                    {
                    match(input,29,FOLLOW_29_in_neg_predicate420); 
                    pushFollow(FOLLOW_neg_predicate_in_neg_predicate424);
                    n=neg_predicate();

                    state._fsp--;

                     e = new NotExpr(n); 

                    }
                    break;
                case 2 :
                    // Lute.g:126:5: a= atomic_predicate
                    {
                    pushFollow(FOLLOW_atomic_predicate_in_neg_predicate434);
                    a=atomic_predicate();

                    state._fsp--;

                     e = a; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "neg_predicate"


    // $ANTLR start "atomic_predicate"
    // Lute.g:129:1: atomic_predicate returns [Expr e] : l= term (op= ( '=' | '>' | '<' | '>=' | '<=' | '!=' ) r= term )? ;
    public final Expr atomic_predicate() throws RecognitionException {
        Expr e = null;

        Token op=null;
        Expr l = null;

        Expr r = null;


        try {
            // Lute.g:130:3: (l= term (op= ( '=' | '>' | '<' | '>=' | '<=' | '!=' ) r= term )? )
            // Lute.g:130:5: l= term (op= ( '=' | '>' | '<' | '>=' | '<=' | '!=' ) r= term )?
            {
            pushFollow(FOLLOW_term_in_atomic_predicate455);
            l=term();

            state._fsp--;

             e = l; 
            // Lute.g:131:5: (op= ( '=' | '>' | '<' | '>=' | '<=' | '!=' ) r= term )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=30 && LA9_0<=35)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Lute.g:131:6: op= ( '=' | '>' | '<' | '>=' | '<=' | '!=' ) r= term
                    {
                    op=(Token)input.LT(1);
                    if ( (input.LA(1)>=30 && input.LA(1)<=35) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_term_in_atomic_predicate492);
                    r=term();

                    state._fsp--;

                     e = new FnCallExpr(op.getText(), Arrays.asList(e, r)); 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "atomic_predicate"


    // $ANTLR start "term"
    // Lute.g:135:1: term returns [Expr e] : l= factor (op= ( '+' | '-' ) r= factor )* ;
    public final Expr term() throws RecognitionException {
        Expr e = null;

        Token op=null;
        Expr l = null;

        Expr r = null;


        try {
            // Lute.g:136:3: (l= factor (op= ( '+' | '-' ) r= factor )* )
            // Lute.g:136:5: l= factor (op= ( '+' | '-' ) r= factor )*
            {
            pushFollow(FOLLOW_factor_in_term524);
            l=factor();

            state._fsp--;

             e = l; 
            // Lute.g:137:5: (op= ( '+' | '-' ) r= factor )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=36 && LA10_0<=37)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Lute.g:137:6: op= ( '+' | '-' ) r= factor
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=36 && input.LA(1)<=37) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_factor_in_term545);
            	    r=factor();

            	    state._fsp--;

            	     e = new FnCallExpr(op.getText(), Arrays.asList(e, r)); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "term"


    // $ANTLR start "factor"
    // Lute.g:141:1: factor returns [Expr e] : l= base (op= '*' r= base )* ;
    public final Expr factor() throws RecognitionException {
        Expr e = null;

        Token op=null;
        Expr l = null;

        Expr r = null;


        try {
            // Lute.g:142:3: (l= base (op= '*' r= base )* )
            // Lute.g:142:5: l= base (op= '*' r= base )*
            {
            pushFollow(FOLLOW_base_in_factor574);
            l=base();

            state._fsp--;

             e = l; 
            // Lute.g:143:5: (op= '*' r= base )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==38) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Lute.g:143:6: op= '*' r= base
            	    {
            	    op=(Token)match(input,38,FOLLOW_38_in_factor585); 
            	    pushFollow(FOLLOW_base_in_factor589);
            	    r=base();

            	    state._fsp--;

            	     e = new FnCallExpr(op.getText(), Arrays.asList(e, r)); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "factor"


    // $ANTLR start "base"
    // Lute.g:147:1: base returns [Expr e] : ( ID | INT | STRING | bool | ID '(' (arg= expr ( ',' arg= expr )* )? ')' | '{' (map= expr 'for' )? ID 'in' domain= expr ( '|' filter= expr )? '}' | '(' expr ')' );
    public final Expr base() throws RecognitionException {
        Expr e = null;

        Token ID13=null;
        Token INT14=null;
        Token STRING15=null;
        Token ID17=null;
        Token ID18=null;
        Expr arg = null;

        Expr map = null;

        Expr domain = null;

        Expr filter = null;

        Expr bool16 = null;

        Expr expr19 = null;


        try {
            // Lute.g:148:3: ( ID | INT | STRING | bool | ID '(' (arg= expr ( ',' arg= expr )* )? ')' | '{' (map= expr 'for' )? ID 'in' domain= expr ( '|' filter= expr )? '}' | '(' expr ')' )
            int alt16=7;
            switch ( input.LA(1) ) {
            case ID:
                {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==16) ) {
                    alt16=5;
                }
                else if ( (LA16_1==14||(LA16_1>=17 && LA16_1<=18)||LA16_1==21||(LA16_1>=25 && LA16_1<=28)||(LA16_1>=30 && LA16_1<=38)||(LA16_1>=40 && LA16_1<=42)) ) {
                    alt16=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
                }
                break;
            case INT:
                {
                alt16=2;
                }
                break;
            case STRING:
                {
                alt16=3;
                }
                break;
            case 43:
            case 44:
                {
                alt16=4;
                }
                break;
            case 39:
                {
                alt16=6;
                }
                break;
            case 16:
                {
                alt16=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // Lute.g:148:5: ID
                    {
                    ID13=(Token)match(input,ID,FOLLOW_ID_in_base616); 
                     e = new IdExpr((ID13!=null?ID13.getText():null)); 

                    }
                    break;
                case 2 :
                    // Lute.g:150:5: INT
                    {
                    INT14=(Token)match(input,INT,FOLLOW_INT_in_base628); 
                     e = new IntVal(new BigInteger((INT14!=null?INT14.getText():null))); 

                    }
                    break;
                case 3 :
                    // Lute.g:152:5: STRING
                    {
                    STRING15=(Token)match(input,STRING,FOLLOW_STRING_in_base640); 
                     e = new StringVal((STRING15!=null?STRING15.getText():null).substring(1, (STRING15!=null?STRING15.getText():null).length()-1)); 

                    }
                    break;
                case 4 :
                    // Lute.g:154:5: bool
                    {
                    pushFollow(FOLLOW_bool_in_base652);
                    bool16=bool();

                    state._fsp--;

                     e = bool16; 

                    }
                    break;
                case 5 :
                    // Lute.g:156:5: ID '(' (arg= expr ( ',' arg= expr )* )? ')'
                    {
                     List<Expr> args = new ArrayList<Expr>(); 
                    ID17=(Token)match(input,ID,FOLLOW_ID_in_base670); 
                    match(input,16,FOLLOW_16_in_base672); 
                    // Lute.g:157:12: (arg= expr ( ',' arg= expr )* )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( ((LA13_0>=ID && LA13_0<=STRING)||LA13_0==16||LA13_0==24||LA13_0==29||LA13_0==39||(LA13_0>=43 && LA13_0<=44)) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // Lute.g:157:13: arg= expr ( ',' arg= expr )*
                            {
                            pushFollow(FOLLOW_expr_in_base677);
                            arg=expr();

                            state._fsp--;

                             args.add(arg); 
                            // Lute.g:158:14: ( ',' arg= expr )*
                            loop12:
                            do {
                                int alt12=2;
                                int LA12_0 = input.LA(1);

                                if ( (LA12_0==17) ) {
                                    alt12=1;
                                }


                                switch (alt12) {
                            	case 1 :
                            	    // Lute.g:158:15: ',' arg= expr
                            	    {
                            	    match(input,17,FOLLOW_17_in_base695); 
                            	    pushFollow(FOLLOW_expr_in_base699);
                            	    arg=expr();

                            	    state._fsp--;

                            	     args.add(arg); 

                            	    }
                            	    break;

                            	default :
                            	    break loop12;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,18,FOLLOW_18_in_base707); 
                     e = new FnCallExpr((ID17!=null?ID17.getText():null), args); 

                    }
                    break;
                case 6 :
                    // Lute.g:160:5: '{' (map= expr 'for' )? ID 'in' domain= expr ( '|' filter= expr )? '}'
                    {
                    match(input,39,FOLLOW_39_in_base719); 
                    // Lute.g:160:9: (map= expr 'for' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( ((LA14_0>=INT && LA14_0<=STRING)||LA14_0==16||LA14_0==24||LA14_0==29||LA14_0==39||(LA14_0>=43 && LA14_0<=44)) ) {
                        alt14=1;
                    }
                    else if ( (LA14_0==ID) ) {
                        int LA14_2 = input.LA(2);

                        if ( (LA14_2==16||(LA14_2>=27 && LA14_2<=28)||(LA14_2>=30 && LA14_2<=38)||LA14_2==40) ) {
                            alt14=1;
                        }
                    }
                    switch (alt14) {
                        case 1 :
                            // Lute.g:160:10: map= expr 'for'
                            {
                            pushFollow(FOLLOW_expr_in_base724);
                            map=expr();

                            state._fsp--;

                            match(input,40,FOLLOW_40_in_base726); 

                            }
                            break;

                    }

                    ID18=(Token)match(input,ID,FOLLOW_ID_in_base730); 
                    match(input,20,FOLLOW_20_in_base732); 
                    pushFollow(FOLLOW_expr_in_base736);
                    domain=expr();

                    state._fsp--;

                    // Lute.g:160:47: ( '|' filter= expr )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==41) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // Lute.g:160:48: '|' filter= expr
                            {
                            match(input,41,FOLLOW_41_in_base739); 
                            pushFollow(FOLLOW_expr_in_base743);
                            filter=expr();

                            state._fsp--;


                            }
                            break;

                    }

                    match(input,42,FOLLOW_42_in_base747); 
                     e = new FilterMapExpr(map, (ID18!=null?ID18.getText():null), domain, filter); 

                    }
                    break;
                case 7 :
                    // Lute.g:162:5: '(' expr ')'
                    {
                    match(input,16,FOLLOW_16_in_base759); 
                    pushFollow(FOLLOW_expr_in_base761);
                    expr19=expr();

                    state._fsp--;

                    match(input,18,FOLLOW_18_in_base763); 
                     e = expr19; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "base"


    // $ANTLR start "bool"
    // Lute.g:166:1: bool returns [Expr e] : ( 'true' | 'false' );
    public final Expr bool() throws RecognitionException {
        Expr e = null;

        try {
            // Lute.g:167:3: ( 'true' | 'false' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==43) ) {
                alt17=1;
            }
            else if ( (LA17_0==44) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // Lute.g:167:5: 'true'
                    {
                    match(input,43,FOLLOW_43_in_bool788); 
                     e = new BoolVal(true); 

                    }
                    break;
                case 2 :
                    // Lute.g:168:5: 'false'
                    {
                    match(input,44,FOLLOW_44_in_bool798); 
                     e = new BoolVal(false); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "bool"

    // Delegated rules


 

    public static final BitSet FOLLOW_command_in_rule66 = new BitSet(new long[]{0x0000000000001012L});
    public static final BitSet FOLLOW_12_in_command87 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_command89 = new BitSet(new long[]{0x0000000000C80010L});
    public static final BitSet FOLLOW_stmt_in_command91 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_command93 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_command95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_command107 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_command109 = new BitSet(new long[]{0x0000188021010070L});
    public static final BitSet FOLLOW_expr_in_command111 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_command113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_command133 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_command135 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_command139 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_command158 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_command162 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_command168 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_command170 = new BitSet(new long[]{0x0000188021010070L});
    public static final BitSet FOLLOW_expr_in_command172 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_command174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_stmt197 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_stmt199 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_stmt201 = new BitSet(new long[]{0x0000188021010070L});
    public static final BitSet FOLLOW_expr_in_stmt203 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_stmt205 = new BitSet(new long[]{0x0000000000C80010L});
    public static final BitSet FOLLOW_stmt_in_stmt209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_stmt221 = new BitSet(new long[]{0x0000188021010070L});
    public static final BitSet FOLLOW_expr_in_stmt223 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_stmt225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_stmt237 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_stmt239 = new BitSet(new long[]{0x0000188021010070L});
    public static final BitSet FOLLOW_expr_in_stmt241 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_stmt243 = new BitSet(new long[]{0x0000000000C80010L});
    public static final BitSet FOLLOW_stmt_in_stmt247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_stmt265 = new BitSet(new long[]{0x0000188021010070L});
    public static final BitSet FOLLOW_expr_in_stmt269 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_17_in_stmt280 = new BitSet(new long[]{0x0000188021010070L});
    public static final BitSet FOLLOW_expr_in_stmt284 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_14_in_stmt291 = new BitSet(new long[]{0x0000000000C80010L});
    public static final BitSet FOLLOW_stmt_in_stmt299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_expr322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_expr330 = new BitSet(new long[]{0x0000188020010070L});
    public static final BitSet FOLLOW_predicate_in_expr334 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_expr336 = new BitSet(new long[]{0x0000188020010070L});
    public static final BitSet FOLLOW_predicate_in_expr340 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_expr342 = new BitSet(new long[]{0x0000188020010070L});
    public static final BitSet FOLLOW_predicate_in_expr346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_neg_predicate_in_predicate371 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_27_in_predicate380 = new BitSet(new long[]{0x0000188020010070L});
    public static final BitSet FOLLOW_neg_predicate_in_predicate384 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_28_in_predicate395 = new BitSet(new long[]{0x0000188020010070L});
    public static final BitSet FOLLOW_neg_predicate_in_predicate399 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_29_in_neg_predicate420 = new BitSet(new long[]{0x0000188020010070L});
    public static final BitSet FOLLOW_neg_predicate_in_neg_predicate424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_predicate_in_neg_predicate434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_atomic_predicate455 = new BitSet(new long[]{0x0000000FC0000002L});
    public static final BitSet FOLLOW_set_in_atomic_predicate466 = new BitSet(new long[]{0x0000188020010070L});
    public static final BitSet FOLLOW_term_in_atomic_predicate492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factor_in_term524 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_set_in_term535 = new BitSet(new long[]{0x0000188020010070L});
    public static final BitSet FOLLOW_factor_in_term545 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_base_in_factor574 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_factor585 = new BitSet(new long[]{0x0000188020010070L});
    public static final BitSet FOLLOW_base_in_factor589 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ID_in_base616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_base628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_base640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bool_in_base652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_base670 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_base672 = new BitSet(new long[]{0x0000188021050070L});
    public static final BitSet FOLLOW_expr_in_base677 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_base695 = new BitSet(new long[]{0x0000188021010070L});
    public static final BitSet FOLLOW_expr_in_base699 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_base707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_base719 = new BitSet(new long[]{0x0000188021010070L});
    public static final BitSet FOLLOW_expr_in_base724 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_base726 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_base730 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_base732 = new BitSet(new long[]{0x0000188021010070L});
    public static final BitSet FOLLOW_expr_in_base736 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_41_in_base739 = new BitSet(new long[]{0x0000188021010070L});
    public static final BitSet FOLLOW_expr_in_base743 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_base747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_base759 = new BitSet(new long[]{0x0000188021010070L});
    public static final BitSet FOLLOW_expr_in_base761 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_base763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_bool788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_bool798 = new BitSet(new long[]{0x0000000000000002L});

}