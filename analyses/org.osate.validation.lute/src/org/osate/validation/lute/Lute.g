/*
Copyright (c) 2011, Rockwell Collins.
Developed with the sponsorship of the Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/

grammar Lute;

options {
  language = Java;
}

@header{
  package com.rockwellcollins.atc.meta.lute;
  
  import java.util.Arrays;
  import java.math.BigInteger;
  import com.rockwellcollins.atc.meta.Logger;
}

@members{
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
}

@lexer::header{
  package com.rockwellcollins.atc.meta.lute;
  
  import com.rockwellcollins.atc.meta.Logger;
}

@lexer::members{
  private Logger log;
  
  public LuteLexer(CharStream input, Logger log) {
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
}

rule returns [List<Command> cmds]
  : { $cmds = new ArrayList<Command>(); }
    (command { $cmds.add($command.c); })*
  ;

command returns [Command c]
  : 'theorem' ID stmt 'end' ';'
    { $c = new Theorem($ID.text, $stmt.s); }
  | ID ':=' expr ';'
    { $c = new Assignment($ID.text, $expr.e); }
  | { ArrayList<String> args = new ArrayList<String>(); }
    fn=ID '(' arg=ID { args.add($arg.text); }
              (',' arg=ID { args.add($arg.text); })* ')' ':=' expr ';'
    { $c = new FunctionDefinition($fn.text, args, $expr.e); }
  ;

stmt returns [Stmt s]
  : 'foreach' ID 'in' expr 'do' body=stmt
    { $s = new ForeachStmt($ID.text, $expr.e, $body.s); }
  | 'check' expr ';'
    { $s = new CheckStmt($expr.e); }
  | ID ':=' expr ';' body=stmt
    { $s = new LetStmt($ID.text, $expr.e, $body.s); }
  | { ArrayList<Expr> exprs = new ArrayList<Expr>(); }
    'print' d=expr { exprs.add($d.e); }
      (',' d=expr { exprs.add($d.e); } )* ';'
    body=stmt
    { $s = new PrintStmt(exprs, $body.s); }
  ;

expr returns [Expr e]
  : predicate { $e = $predicate.e; }
  | 'if' c=predicate 'then' t=predicate 'else' f=predicate
    { $e = new IfExpr($c.e, $t.e, $f.e); }
  ;

predicate returns [Expr e]
  : l=neg_predicate { $e = $l.e; }
    ('and' r=neg_predicate { $e = new AndExpr($e, $r.e); } |
     'or' r=neg_predicate { $e = new OrExpr($e, $r.e); })*
  ;

neg_predicate returns [Expr e]
  : 'not' n=neg_predicate { $e = new NotExpr($n.e); }
  | a=atomic_predicate { $e = $a.e; }
  ;

atomic_predicate returns [Expr e]
  : l=term { $e = $l.e; }
    (op=('=' | '>' | '<' | '>=' | '<=' | '!=') r=term
     { $e = new FnCallExpr($op.getText(), Arrays.asList($e, $r.e)); } )? 
  ;
  
term returns [Expr e]
  : l=factor { $e = $l.e; }
    (op=('+' | '-') r=factor
     { $e = new FnCallExpr($op.getText(), Arrays.asList($e, $r.e)); } )*
  ;

factor returns [Expr e]
  : l=base { $e = $l.e; }
    (op='*' r=base
     { $e = new FnCallExpr($op.getText(), Arrays.asList($e, $r.e)); } )*
  ;

base returns [Expr e]
  : ID
    { $e = new IdExpr($ID.text); }
  | INT
    { $e = new IntVal(new BigInteger($INT.text)); }
  | STRING
    { $e = new StringVal($STRING.text.substring(1, $STRING.text.length()-1)); }
  | bool
    { $e = $bool.e; }
  | { List<Expr> args = new ArrayList<Expr>(); }
    ID '(' (arg=expr { args.add($arg.e); }
             (',' arg=expr { args.add($arg.e); })*)? ')'
    { $e = new FnCallExpr($ID.text, args); }
  | '{' (map=expr 'for')? ID 'in' domain=expr ('|' filter=expr)? '}'
    { $e = new FilterMapExpr($map.e, $ID.text, $domain.e, $filter.e); }
  | '(' expr ')'
    { $e = $expr.e; }
  ;
  
bool returns [Expr e]
  : 'true'   { $e = new BoolVal(true); }
  | 'false'  { $e = new BoolVal(false); }
  ;
  
fragment LETTER: 'a'..'z' | 'A'..'Z' ;
fragment DIGIT: '0'..'9';
fragment SPECIAL: '_' | '.' | '::';
INT: '-'? DIGIT+;
ID: LETTER (LETTER | DIGIT | SPECIAL)*;
STRING: '"' (~'"')* '"';
WS: (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};
COMMENT: '--' (~('\n'|'\r'))* {$channel = HIDDEN;};
