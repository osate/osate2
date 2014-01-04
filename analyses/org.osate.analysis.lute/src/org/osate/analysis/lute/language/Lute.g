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
  package org.osate.analysis.lute.language;
  
  import java.util.Arrays;
  import org.slf4j.Logger;
}

@members{
  private Logger log;
  
  public LuteParser(TokenStream input, Logger log) {
    this(input);
    this.log = log;
  }
  
  @Override
  public void emitErrorMessage(String msg) {
    if (log == null) {
        throw new LuteException( msg );
    } 

    log.error(msg);
  }
}

@lexer::header{
  package org.osate.analysis.lute.language;
  
  import org.slf4j.Logger;
}

@lexer::members{
  private Logger log;
  
  public LuteLexer(CharStream input, Logger log) {
    this(input);
    this.log = log;
  }
  
  @Override
  public void emitErrorMessage(String msg) {
    if (log == null) {
        throw new LuteException( msg );
    } 

    log.error(msg);
  }
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
    (op=('*' | '\/' | '^') r=base
     { $e = new FnCallExpr($op.getText(), Arrays.asList($e, $r.e)); } )*
  ;

base returns [Expr e]
  : ID
    { $e = new IdExpr($ID.text); }
  | INT
    { $e = new IntVal(new Long($INT.text)); }
  | REAL
    { $e = new RealVal(new Double($REAL.text)); }
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
REAL: '-'? DIGIT+ '.' DIGIT+ ('E'INT)? | '-'? '.' DIGIT+ ('E'INT)?;
ID: LETTER (LETTER | DIGIT | SPECIAL)*;
STRING: '"' (~'"')* '"';
WS: (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};
COMMENT: '--' (~('\n'|'\r'))* {$channel = HIDDEN;};

/*

Elements not included in this grammar:

-- Predefined model elements
Self
Owner
Source
Destination
Connection_Set 
Abstract_Set
Bus_Set
Data_Set
Device_Set
Memory_Set
Process_Set
Processor_Set
Subprogram_Set
Subprogram_Group_Set
System_Set
Thread_Set
Thread_Group_Set
Virtual_Bus_Set
Virtual_Processor_Set

-- Predefined Functions
Property
Property_Exists
Is_Subcomponent_Of
Is_Of_Type
Is_Bound_To

-- Set Functions
Member
Max
Min
Sum
Cardinal
First
At
Last

-- Range Functions
Lower
Upper

-- String Functions 
Concat
Substring
Index_Of
Length
*/



