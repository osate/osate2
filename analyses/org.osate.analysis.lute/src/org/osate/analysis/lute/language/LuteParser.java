// $ANTLR 3.3 Nov 30, 2010 12:50:56 Lute.g 2013-01-30 10:24:41

  package org.osate.analysis.lute.language;
  
  import java.util.Arrays;
  import java.math.BigInteger;
  import org.osate.analysis.lute.utils.Logger;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class LuteParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "STRING", "LETTER", "DIGIT", "SPECIAL", "WS", "COMMENT", "ERROR", "'theorem'", "'end'", "';'", "':='", "'('", "','", "')'", "'foreach'", "'in'", "'do'", "'check'", "'when'", "'print'", "'if'", "'then'", "'else'", "'and'", "'or'", "'not'", "'='", "'>'", "'<'", "'>='", "'<='", "'!='", "'+'", "'-'", "'*'", "'{'", "'for'", "'|'", "'}'", "'true'", "'false'"
    };
    public static final int EOF=-1;
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
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int ID=4;
    public static final int INT=5;
    public static final int STRING=6;
    public static final int LETTER=7;
    public static final int DIGIT=8;
    public static final int SPECIAL=9;
    public static final int WS=10;
    public static final int COMMENT=11;
    public static final int ERROR=12;

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
    // Lute.g:64:1: rule returns [List<Command> cmds] : ( command )* ;
    public final List<Command> rule() throws RecognitionException {
        List<Command> cmds = null;

        Command command1 = null;


        try {
            // Lute.g:65:3: ( ( command )* )
            // Lute.g:65:5: ( command )*
            {
             cmds = new ArrayList<Command>(); 
            // Lute.g:66:5: ( command )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Lute.g:66:6: command
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
    // Lute.g:69:1: command returns [Command c] : ( 'theorem' ID stmt 'end' ';' | ID ':=' expr ';' | fn= ID '(' arg= ID ( ',' arg= ID )* ')' ':=' expr ';' );
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
            // Lute.g:70:3: ( 'theorem' ID stmt 'end' ';' | ID ':=' expr ';' | fn= ID '(' arg= ID ( ',' arg= ID )* ')' ':=' expr ';' )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            else if ( (LA3_0==ID) ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==16) ) {
                    alt3=2;
                }
                else if ( (LA3_2==17) ) {
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
                    // Lute.g:70:5: 'theorem' ID stmt 'end' ';'
                    {
                    match(input,13,FOLLOW_13_in_command87); 
                    ID2=(Token)match(input,ID,FOLLOW_ID_in_command89); 
                    pushFollow(FOLLOW_stmt_in_command91);
                    stmt3=stmt();

                    state._fsp--;

                    match(input,14,FOLLOW_14_in_command93); 
                    match(input,15,FOLLOW_15_in_command95); 
                     c = new Theorem((ID2!=null?ID2.getText():null), stmt3); 

                    }
                    break;
                case 2 :
                    // Lute.g:72:5: ID ':=' expr ';'
                    {
                    ID4=(Token)match(input,ID,FOLLOW_ID_in_command107); 
                    match(input,16,FOLLOW_16_in_command109); 
                    pushFollow(FOLLOW_expr_in_command111);
                    expr5=expr();

                    state._fsp--;

                    match(input,15,FOLLOW_15_in_command113); 
                     c = new Assignment((ID4!=null?ID4.getText():null), expr5); 

                    }
                    break;
                case 3 :
                    // Lute.g:74:5: fn= ID '(' arg= ID ( ',' arg= ID )* ')' ':=' expr ';'
                    {
                     ArrayList<String> args = new ArrayList<String>(); 
                    fn=(Token)match(input,ID,FOLLOW_ID_in_command133); 
                    match(input,17,FOLLOW_17_in_command135); 
                    arg=(Token)match(input,ID,FOLLOW_ID_in_command139); 
                     args.add((arg!=null?arg.getText():null)); 
                    // Lute.g:76:15: ( ',' arg= ID )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==18) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // Lute.g:76:16: ',' arg= ID
                    	    {
                    	    match(input,18,FOLLOW_18_in_command158); 
                    	    arg=(Token)match(input,ID,FOLLOW_ID_in_command162); 
                    	     args.add((arg!=null?arg.getText():null)); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    match(input,19,FOLLOW_19_in_command168); 
                    match(input,16,FOLLOW_16_in_command170); 
                    pushFollow(FOLLOW_expr_in_command172);
                    expr6=expr();

                    state._fsp--;

                    match(input,15,FOLLOW_15_in_command174); 
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
    // Lute.g:80:1: stmt returns [Stmt s] : ( 'foreach' ID 'in' expr 'do' body= stmt | 'check' c= expr ( ',' d= expr )* ';' | ID ':=' expr ';' body= stmt | 'when' expr 'do' body= stmt | 'print' d= expr ( ',' d= expr )* ';' body= stmt );
    public final Stmt stmt() throws RecognitionException {
        Stmt s = null;

        Token ID7=null;
        Token ID9=null;
        Stmt body = null;

        Expr c = null;

        Expr d = null;

        Expr expr8 = null;

        Expr expr10 = null;

        Expr expr11 = null;


        try {
            // Lute.g:81:3: ( 'foreach' ID 'in' expr 'do' body= stmt | 'check' c= expr ( ',' d= expr )* ';' | ID ':=' expr ';' body= stmt | 'when' expr 'do' body= stmt | 'print' d= expr ( ',' d= expr )* ';' body= stmt )
            int alt6=5;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt6=1;
                }
                break;
            case 23:
                {
                alt6=2;
                }
                break;
            case ID:
                {
                alt6=3;
                }
                break;
            case 24:
                {
                alt6=4;
                }
                break;
            case 25:
                {
                alt6=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // Lute.g:81:5: 'foreach' ID 'in' expr 'do' body= stmt
                    {
                    match(input,20,FOLLOW_20_in_stmt197); 
                    ID7=(Token)match(input,ID,FOLLOW_ID_in_stmt199); 
                    match(input,21,FOLLOW_21_in_stmt201); 
                    pushFollow(FOLLOW_expr_in_stmt203);
                    expr8=expr();

                    state._fsp--;

                    match(input,22,FOLLOW_22_in_stmt205); 
                    pushFollow(FOLLOW_stmt_in_stmt209);
                    body=stmt();

                    state._fsp--;

                     s = new ForeachStmt((ID7!=null?ID7.getText():null), expr8, body); 

                    }
                    break;
                case 2 :
                    // Lute.g:83:5: 'check' c= expr ( ',' d= expr )* ';'
                    {
                     ArrayList<Expr> exprs = new ArrayList<Expr>(); 
                    match(input,23,FOLLOW_23_in_stmt227); 
                    pushFollow(FOLLOW_expr_in_stmt231);
                    c=expr();

                    state._fsp--;

                    // Lute.g:84:20: ( ',' d= expr )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==18) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // Lute.g:84:21: ',' d= expr
                    	    {
                    	    match(input,18,FOLLOW_18_in_stmt234); 
                    	    pushFollow(FOLLOW_expr_in_stmt238);
                    	    d=expr();

                    	    state._fsp--;

                    	     exprs.add(d); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match(input,15,FOLLOW_15_in_stmt245); 
                     s = new CheckStmt(c, exprs); 

                    }
                    break;
                case 3 :
                    // Lute.g:86:5: ID ':=' expr ';' body= stmt
                    {
                    ID9=(Token)match(input,ID,FOLLOW_ID_in_stmt257); 
                    match(input,16,FOLLOW_16_in_stmt259); 
                    pushFollow(FOLLOW_expr_in_stmt261);
                    expr10=expr();

                    state._fsp--;

                    match(input,15,FOLLOW_15_in_stmt263); 
                    pushFollow(FOLLOW_stmt_in_stmt267);
                    body=stmt();

                    state._fsp--;

                     s = new LetStmt((ID9!=null?ID9.getText():null), expr10, body); 

                    }
                    break;
                case 4 :
                    // Lute.g:88:5: 'when' expr 'do' body= stmt
                    {
                    match(input,24,FOLLOW_24_in_stmt279); 
                    pushFollow(FOLLOW_expr_in_stmt281);
                    expr11=expr();

                    state._fsp--;

                    match(input,22,FOLLOW_22_in_stmt283); 
                    pushFollow(FOLLOW_stmt_in_stmt287);
                    body=stmt();

                    state._fsp--;

                     s = new WhenStmt(expr11, body); 

                    }
                    break;
                case 5 :
                    // Lute.g:90:5: 'print' d= expr ( ',' d= expr )* ';' body= stmt
                    {
                     ArrayList<Expr> exprs = new ArrayList<Expr>(); 
                    match(input,25,FOLLOW_25_in_stmt305); 
                    pushFollow(FOLLOW_expr_in_stmt309);
                    d=expr();

                    state._fsp--;

                     exprs.add(d); 
                    // Lute.g:92:7: ( ',' d= expr )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==18) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // Lute.g:92:8: ',' d= expr
                    	    {
                    	    match(input,18,FOLLOW_18_in_stmt320); 
                    	    pushFollow(FOLLOW_expr_in_stmt324);
                    	    d=expr();

                    	    state._fsp--;

                    	     exprs.add(d); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match(input,15,FOLLOW_15_in_stmt331); 
                    pushFollow(FOLLOW_stmt_in_stmt339);
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
    // Lute.g:97:1: expr returns [Expr e] : ( predicate | 'if' c= predicate 'then' t= predicate 'else' f= predicate );
    public final Expr expr() throws RecognitionException {
        Expr e = null;

        Expr c = null;

        Expr t = null;

        Expr f = null;

        Expr predicate12 = null;


        try {
            // Lute.g:98:3: ( predicate | 'if' c= predicate 'then' t= predicate 'else' f= predicate )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=ID && LA7_0<=STRING)||LA7_0==17||LA7_0==31||LA7_0==41||(LA7_0>=45 && LA7_0<=46)) ) {
                alt7=1;
            }
            else if ( (LA7_0==26) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // Lute.g:98:5: predicate
                    {
                    pushFollow(FOLLOW_predicate_in_expr362);
                    predicate12=predicate();

                    state._fsp--;

                     e = predicate12; 

                    }
                    break;
                case 2 :
                    // Lute.g:99:5: 'if' c= predicate 'then' t= predicate 'else' f= predicate
                    {
                    match(input,26,FOLLOW_26_in_expr370); 
                    pushFollow(FOLLOW_predicate_in_expr374);
                    c=predicate();

                    state._fsp--;

                    match(input,27,FOLLOW_27_in_expr376); 
                    pushFollow(FOLLOW_predicate_in_expr380);
                    t=predicate();

                    state._fsp--;

                    match(input,28,FOLLOW_28_in_expr382); 
                    pushFollow(FOLLOW_predicate_in_expr386);
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
    // Lute.g:103:1: predicate returns [Expr e] : l= neg_predicate ( 'and' r= neg_predicate | 'or' r= neg_predicate )* ;
    public final Expr predicate() throws RecognitionException {
        Expr e = null;

        Expr l = null;

        Expr r = null;


        try {
            // Lute.g:104:3: (l= neg_predicate ( 'and' r= neg_predicate | 'or' r= neg_predicate )* )
            // Lute.g:104:5: l= neg_predicate ( 'and' r= neg_predicate | 'or' r= neg_predicate )*
            {
            pushFollow(FOLLOW_neg_predicate_in_predicate411);
            l=neg_predicate();

            state._fsp--;

             e = l; 
            // Lute.g:105:5: ( 'and' r= neg_predicate | 'or' r= neg_predicate )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==29) ) {
                    alt8=1;
                }
                else if ( (LA8_0==30) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // Lute.g:105:6: 'and' r= neg_predicate
            	    {
            	    match(input,29,FOLLOW_29_in_predicate420); 
            	    pushFollow(FOLLOW_neg_predicate_in_predicate424);
            	    r=neg_predicate();

            	    state._fsp--;

            	     e = new AndExpr(e, r); 

            	    }
            	    break;
            	case 2 :
            	    // Lute.g:106:6: 'or' r= neg_predicate
            	    {
            	    match(input,30,FOLLOW_30_in_predicate435); 
            	    pushFollow(FOLLOW_neg_predicate_in_predicate439);
            	    r=neg_predicate();

            	    state._fsp--;

            	     e = new OrExpr(e, r); 

            	    }
            	    break;

            	default :
            	    break loop8;
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
    // Lute.g:109:1: neg_predicate returns [Expr e] : ( 'not' n= neg_predicate | a= atomic_predicate );
    public final Expr neg_predicate() throws RecognitionException {
        Expr e = null;

        Expr n = null;

        Expr a = null;


        try {
            // Lute.g:110:3: ( 'not' n= neg_predicate | a= atomic_predicate )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==31) ) {
                alt9=1;
            }
            else if ( ((LA9_0>=ID && LA9_0<=STRING)||LA9_0==17||LA9_0==41||(LA9_0>=45 && LA9_0<=46)) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // Lute.g:110:5: 'not' n= neg_predicate
                    {
                    match(input,31,FOLLOW_31_in_neg_predicate460); 
                    pushFollow(FOLLOW_neg_predicate_in_neg_predicate464);
                    n=neg_predicate();

                    state._fsp--;

                     e = new NotExpr(n); 

                    }
                    break;
                case 2 :
                    // Lute.g:111:5: a= atomic_predicate
                    {
                    pushFollow(FOLLOW_atomic_predicate_in_neg_predicate474);
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
    // Lute.g:114:1: atomic_predicate returns [Expr e] : l= term (op= ( '=' | '>' | '<' | '>=' | '<=' | '!=' ) r= term )? ;
    public final Expr atomic_predicate() throws RecognitionException {
        Expr e = null;

        Token op=null;
        Expr l = null;

        Expr r = null;


        try {
            // Lute.g:115:3: (l= term (op= ( '=' | '>' | '<' | '>=' | '<=' | '!=' ) r= term )? )
            // Lute.g:115:5: l= term (op= ( '=' | '>' | '<' | '>=' | '<=' | '!=' ) r= term )?
            {
            pushFollow(FOLLOW_term_in_atomic_predicate495);
            l=term();

            state._fsp--;

             e = l; 
            // Lute.g:116:5: (op= ( '=' | '>' | '<' | '>=' | '<=' | '!=' ) r= term )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=32 && LA10_0<=37)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Lute.g:116:6: op= ( '=' | '>' | '<' | '>=' | '<=' | '!=' ) r= term
                    {
                    op=(Token)input.LT(1);
                    if ( (input.LA(1)>=32 && input.LA(1)<=37) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_term_in_atomic_predicate532);
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
    // Lute.g:120:1: term returns [Expr e] : l= factor (op= ( '+' | '-' ) r= factor )* ;
    public final Expr term() throws RecognitionException {
        Expr e = null;

        Token op=null;
        Expr l = null;

        Expr r = null;


        try {
            // Lute.g:121:3: (l= factor (op= ( '+' | '-' ) r= factor )* )
            // Lute.g:121:5: l= factor (op= ( '+' | '-' ) r= factor )*
            {
            pushFollow(FOLLOW_factor_in_term564);
            l=factor();

            state._fsp--;

             e = l; 
            // Lute.g:122:5: (op= ( '+' | '-' ) r= factor )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=38 && LA11_0<=39)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Lute.g:122:6: op= ( '+' | '-' ) r= factor
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=38 && input.LA(1)<=39) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_factor_in_term585);
            	    r=factor();

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
    // $ANTLR end "term"


    // $ANTLR start "factor"
    // Lute.g:126:1: factor returns [Expr e] : l= base (op= '*' r= base )* ;
    public final Expr factor() throws RecognitionException {
        Expr e = null;

        Token op=null;
        Expr l = null;

        Expr r = null;


        try {
            // Lute.g:127:3: (l= base (op= '*' r= base )* )
            // Lute.g:127:5: l= base (op= '*' r= base )*
            {
            pushFollow(FOLLOW_base_in_factor614);
            l=base();

            state._fsp--;

             e = l; 
            // Lute.g:128:5: (op= '*' r= base )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==40) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // Lute.g:128:6: op= '*' r= base
            	    {
            	    op=(Token)match(input,40,FOLLOW_40_in_factor625); 
            	    pushFollow(FOLLOW_base_in_factor629);
            	    r=base();

            	    state._fsp--;

            	     e = new FnCallExpr(op.getText(), Arrays.asList(e, r)); 

            	    }
            	    break;

            	default :
            	    break loop12;
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
    // Lute.g:132:1: base returns [Expr e] : ( ID | INT | STRING | bool | ID '(' (arg= expr ( ',' arg= expr )* )? ')' | '{' (map= expr 'for' )? ID 'in' domain= expr ( '|' filter= expr )? '}' | '(' expr ')' );
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
            // Lute.g:133:3: ( ID | INT | STRING | bool | ID '(' (arg= expr ( ',' arg= expr )* )? ')' | '{' (map= expr 'for' )? ID 'in' domain= expr ( '|' filter= expr )? '}' | '(' expr ')' )
            int alt17=7;
            switch ( input.LA(1) ) {
            case ID:
                {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==17) ) {
                    alt17=5;
                }
                else if ( (LA17_1==15||(LA17_1>=18 && LA17_1<=19)||LA17_1==22||(LA17_1>=27 && LA17_1<=30)||(LA17_1>=32 && LA17_1<=40)||(LA17_1>=42 && LA17_1<=44)) ) {
                    alt17=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
                }
                break;
            case INT:
                {
                alt17=2;
                }
                break;
            case STRING:
                {
                alt17=3;
                }
                break;
            case 45:
            case 46:
                {
                alt17=4;
                }
                break;
            case 41:
                {
                alt17=6;
                }
                break;
            case 17:
                {
                alt17=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // Lute.g:133:5: ID
                    {
                    ID13=(Token)match(input,ID,FOLLOW_ID_in_base656); 
                     e = new IdExpr((ID13!=null?ID13.getText():null)); 

                    }
                    break;
                case 2 :
                    // Lute.g:135:5: INT
                    {
                    INT14=(Token)match(input,INT,FOLLOW_INT_in_base668); 
                     e = new IntVal(new BigInteger((INT14!=null?INT14.getText():null))); 

                    }
                    break;
                case 3 :
                    // Lute.g:137:5: STRING
                    {
                    STRING15=(Token)match(input,STRING,FOLLOW_STRING_in_base680); 
                     e = new StringVal((STRING15!=null?STRING15.getText():null).substring(1, (STRING15!=null?STRING15.getText():null).length()-1)); 

                    }
                    break;
                case 4 :
                    // Lute.g:139:5: bool
                    {
                    pushFollow(FOLLOW_bool_in_base692);
                    bool16=bool();

                    state._fsp--;

                     e = bool16; 

                    }
                    break;
                case 5 :
                    // Lute.g:141:5: ID '(' (arg= expr ( ',' arg= expr )* )? ')'
                    {
                     List<Expr> args = new ArrayList<Expr>(); 
                    ID17=(Token)match(input,ID,FOLLOW_ID_in_base710); 
                    match(input,17,FOLLOW_17_in_base712); 
                    // Lute.g:142:12: (arg= expr ( ',' arg= expr )* )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( ((LA14_0>=ID && LA14_0<=STRING)||LA14_0==17||LA14_0==26||LA14_0==31||LA14_0==41||(LA14_0>=45 && LA14_0<=46)) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // Lute.g:142:13: arg= expr ( ',' arg= expr )*
                            {
                            pushFollow(FOLLOW_expr_in_base717);
                            arg=expr();

                            state._fsp--;

                             args.add(arg); 
                            // Lute.g:143:14: ( ',' arg= expr )*
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( (LA13_0==18) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // Lute.g:143:15: ',' arg= expr
                            	    {
                            	    match(input,18,FOLLOW_18_in_base735); 
                            	    pushFollow(FOLLOW_expr_in_base739);
                            	    arg=expr();

                            	    state._fsp--;

                            	     args.add(arg); 

                            	    }
                            	    break;

                            	default :
                            	    break loop13;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,19,FOLLOW_19_in_base747); 
                     e = new FnCallExpr((ID17!=null?ID17.getText():null), args); 

                    }
                    break;
                case 6 :
                    // Lute.g:145:5: '{' (map= expr 'for' )? ID 'in' domain= expr ( '|' filter= expr )? '}'
                    {
                    match(input,41,FOLLOW_41_in_base759); 
                    // Lute.g:145:9: (map= expr 'for' )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( ((LA15_0>=INT && LA15_0<=STRING)||LA15_0==17||LA15_0==26||LA15_0==31||LA15_0==41||(LA15_0>=45 && LA15_0<=46)) ) {
                        alt15=1;
                    }
                    else if ( (LA15_0==ID) ) {
                        int LA15_2 = input.LA(2);

                        if ( (LA15_2==17||(LA15_2>=29 && LA15_2<=30)||(LA15_2>=32 && LA15_2<=40)||LA15_2==42) ) {
                            alt15=1;
                        }
                    }
                    switch (alt15) {
                        case 1 :
                            // Lute.g:145:10: map= expr 'for'
                            {
                            pushFollow(FOLLOW_expr_in_base764);
                            map=expr();

                            state._fsp--;

                            match(input,42,FOLLOW_42_in_base766); 

                            }
                            break;

                    }

                    ID18=(Token)match(input,ID,FOLLOW_ID_in_base770); 
                    match(input,21,FOLLOW_21_in_base772); 
                    pushFollow(FOLLOW_expr_in_base776);
                    domain=expr();

                    state._fsp--;

                    // Lute.g:145:47: ( '|' filter= expr )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==43) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // Lute.g:145:48: '|' filter= expr
                            {
                            match(input,43,FOLLOW_43_in_base779); 
                            pushFollow(FOLLOW_expr_in_base783);
                            filter=expr();

                            state._fsp--;


                            }
                            break;

                    }

                    match(input,44,FOLLOW_44_in_base787); 
                     e = new FilterMapExpr(map, (ID18!=null?ID18.getText():null), domain, filter); 

                    }
                    break;
                case 7 :
                    // Lute.g:147:5: '(' expr ')'
                    {
                    match(input,17,FOLLOW_17_in_base799); 
                    pushFollow(FOLLOW_expr_in_base801);
                    expr19=expr();

                    state._fsp--;

                    match(input,19,FOLLOW_19_in_base803); 
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
    // Lute.g:151:1: bool returns [Expr e] : ( 'true' | 'false' );
    public final Expr bool() throws RecognitionException {
        Expr e = null;

        try {
            // Lute.g:152:3: ( 'true' | 'false' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==45) ) {
                alt18=1;
            }
            else if ( (LA18_0==46) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // Lute.g:152:5: 'true'
                    {
                    match(input,45,FOLLOW_45_in_bool828); 
                     e = new BoolVal(true); 

                    }
                    break;
                case 2 :
                    // Lute.g:153:5: 'false'
                    {
                    match(input,46,FOLLOW_46_in_bool838); 
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


 

    public static final BitSet FOLLOW_command_in_rule66 = new BitSet(new long[]{0x0000000000002012L});
    public static final BitSet FOLLOW_13_in_command87 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_command89 = new BitSet(new long[]{0x0000000003900010L});
    public static final BitSet FOLLOW_stmt_in_command91 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_command93 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_command95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_command107 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_command109 = new BitSet(new long[]{0x0000620084020070L});
    public static final BitSet FOLLOW_expr_in_command111 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_command113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_command133 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_command135 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_command139 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_command158 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_command162 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_19_in_command168 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_command170 = new BitSet(new long[]{0x0000620084020070L});
    public static final BitSet FOLLOW_expr_in_command172 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_command174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_stmt197 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_stmt199 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_stmt201 = new BitSet(new long[]{0x0000620084020070L});
    public static final BitSet FOLLOW_expr_in_stmt203 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_stmt205 = new BitSet(new long[]{0x0000000003900010L});
    public static final BitSet FOLLOW_stmt_in_stmt209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_stmt227 = new BitSet(new long[]{0x0000620084020070L});
    public static final BitSet FOLLOW_expr_in_stmt231 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_18_in_stmt234 = new BitSet(new long[]{0x0000620084020070L});
    public static final BitSet FOLLOW_expr_in_stmt238 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15_in_stmt245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_stmt257 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_stmt259 = new BitSet(new long[]{0x0000620084020070L});
    public static final BitSet FOLLOW_expr_in_stmt261 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_stmt263 = new BitSet(new long[]{0x0000000003900010L});
    public static final BitSet FOLLOW_stmt_in_stmt267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_stmt279 = new BitSet(new long[]{0x0000620084020070L});
    public static final BitSet FOLLOW_expr_in_stmt281 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_stmt283 = new BitSet(new long[]{0x0000000003900010L});
    public static final BitSet FOLLOW_stmt_in_stmt287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_stmt305 = new BitSet(new long[]{0x0000620084020070L});
    public static final BitSet FOLLOW_expr_in_stmt309 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_18_in_stmt320 = new BitSet(new long[]{0x0000620084020070L});
    public static final BitSet FOLLOW_expr_in_stmt324 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15_in_stmt331 = new BitSet(new long[]{0x0000000003900010L});
    public static final BitSet FOLLOW_stmt_in_stmt339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_expr362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_expr370 = new BitSet(new long[]{0x0000620080020070L});
    public static final BitSet FOLLOW_predicate_in_expr374 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_expr376 = new BitSet(new long[]{0x0000620080020070L});
    public static final BitSet FOLLOW_predicate_in_expr380 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_expr382 = new BitSet(new long[]{0x0000620080020070L});
    public static final BitSet FOLLOW_predicate_in_expr386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_neg_predicate_in_predicate411 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_29_in_predicate420 = new BitSet(new long[]{0x0000620080020070L});
    public static final BitSet FOLLOW_neg_predicate_in_predicate424 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_30_in_predicate435 = new BitSet(new long[]{0x0000620080020070L});
    public static final BitSet FOLLOW_neg_predicate_in_predicate439 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_31_in_neg_predicate460 = new BitSet(new long[]{0x0000620080020070L});
    public static final BitSet FOLLOW_neg_predicate_in_neg_predicate464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_predicate_in_neg_predicate474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_atomic_predicate495 = new BitSet(new long[]{0x0000003F00000002L});
    public static final BitSet FOLLOW_set_in_atomic_predicate506 = new BitSet(new long[]{0x0000620080020070L});
    public static final BitSet FOLLOW_term_in_atomic_predicate532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factor_in_term564 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_set_in_term575 = new BitSet(new long[]{0x0000620080020070L});
    public static final BitSet FOLLOW_factor_in_term585 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_base_in_factor614 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_factor625 = new BitSet(new long[]{0x0000620080020070L});
    public static final BitSet FOLLOW_base_in_factor629 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ID_in_base656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_base668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_base680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bool_in_base692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_base710 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_base712 = new BitSet(new long[]{0x00006200840A0070L});
    public static final BitSet FOLLOW_expr_in_base717 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_base735 = new BitSet(new long[]{0x0000620084020070L});
    public static final BitSet FOLLOW_expr_in_base739 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_19_in_base747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_base759 = new BitSet(new long[]{0x0000620084020070L});
    public static final BitSet FOLLOW_expr_in_base764 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_base766 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_base770 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_base772 = new BitSet(new long[]{0x0000620084020070L});
    public static final BitSet FOLLOW_expr_in_base776 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_43_in_base779 = new BitSet(new long[]{0x0000620084020070L});
    public static final BitSet FOLLOW_expr_in_base783 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_base787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_base799 = new BitSet(new long[]{0x0000620084020070L});
    public static final BitSet FOLLOW_expr_in_base801 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_base803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_bool828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_bool838 = new BitSet(new long[]{0x0000000000000002L});

}