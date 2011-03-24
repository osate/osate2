package fr.tpt.aadl.annex.behavior.texteditor;

import java.util.ArrayList;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;

public class AadlBaCodeScanner extends RuleBasedScanner
{
   private static Aadl2ColorProvider _colorProvider = new Aadl2ColorProvider();
   
   // Imported from Osate2.
   public final static String[] AADL2_KEYWORDS = new String[]
   {  
      "aadlboolean",
      "aadlinteger",
      "aadlreal",
      "aadlstring",
      "abstract",
      "access",
      "all",
      "and",
      "annex",
      "applies",
      "binding",
      "bus",
      "calls",
      "classifier",
      "compute",
      "connections",
      "constant",
      "data",
      "delta",
      "device",
      "end",
      "enumeration",
      "event",
      "extends",
      "false",
      "feature",
      "features",
      "flow",
      "flows",
      "group",
      "implementation",
      "in",
      "inherit",
      "initial",
      "inverse",
      "is",
      "list",
      "memory",
      "mode",
      "modes",
      "none",
      "not",
      "of",
      "or",
      "out",
      "package",
      "parameter",
      "path",
      "port",
      "private",
      "process",
      "processor",
      "properties",
      "property",
      "prototypes",
      "provides",
      "public",
      "range",
      "record",
      "reference",
      "refined",
      "renames",
      "requires",
      "self",
      "set",
      "sink",
      "source",
      "subcomponents",
      "subprogram",
      "system",
      "thread",
      "to",
      "true",
      "type",
      "units",
      "virtual",
      "with"
   };
   
   public final static String[] BA_KEYWORDS = new String[]
   {  
      "behavior_specification",
      "variables",
      "states",
      "transitions",
      "state",
      "initial",
      "complete",
      "final",
      "otherwise",
      "timeout",
      "on",
      "dispatch",
      "frozen",
      "stop",
      "xor",
      "if",
      "elsif",
      "else",
      "for",
      "forall",
      "while",
      "do",
      "until",
      "any",   
      "computation",
       "'",
      "count",
      "'count",
      "fresh",
      "'fresh",
      "mod",
      "rem",
      "abs"
   };
 
   public final static String[] BA_SIGNS = new String[]
   {
      ":=",
      "!",
      ">>",
      "?",
      "!<",
      "!>",
      "*!<",
      "*!>",
      "!<",
      "!>"
   } ;
  
   public AadlBaCodeScanner()
   {
      Token commentToken = new Token(new TextAttribute(
                                        _colorProvider.getColor(
                                           Aadl2ColorProvider.COMMENT)));
      Token stringToken = new Token(new TextAttribute(
                                       _colorProvider.getColor(
                                           Aadl2ColorProvider.STRING)));
      Token keywordToken = new Token(new TextAttribute(
                                       _colorProvider.getColor(
                                           Aadl2ColorProvider.KEYWORD),
                                       _colorProvider.getColor(
                                           Aadl2ColorProvider.BACKGROUND),
                                           SWT.BOLD));
      
      Token baSignToken = new Token (new TextAttribute(
                                    _colorProvider.getColor(
                                       Aadl2ColorProvider.DEFAULT),
                                    _colorProvider.getColor(
                                       Aadl2ColorProvider.BACKGROUND),
                                       SWT.BOLD));
      
      Token defaultToken = new Token(new TextAttribute(
                                       _colorProvider.getColor(
                                           Aadl2ColorProvider.DEFAULT)));
      
      ArrayList<IRule> rules = new ArrayList<IRule>();
      
      rules.add(new EndOfLineRule("--", commentToken));
      rules.add(new SingleLineRule("\"", "\"", stringToken));
      
      WordRule wordRule = new WordRule(new Aadl2WordDetector(), defaultToken,
                                                                true);
      
      for (String keyword : AADL2_KEYWORDS)
      {
         wordRule.addWord(keyword, keywordToken);
      }
      
      for (String keyword : BA_KEYWORDS)
      {
         wordRule.addWord(keyword, keywordToken);
      }
      
      for(String sign : BA_SIGNS)
      {
         wordRule.addWord(sign, baSignToken);
      }
      
      rules.add(wordRule);
      
      setRules(rules.toArray(new IRule[rules.size()]));
   }
   
   private static class Aadl2WordDetector implements IWordDetector
   {
      @Override
      public boolean isWordStart(char c)
      {
         switch (c)
         {
            case '\'':
            case '?':
            case '>':
            case '*':
            case ':':
            case '!' : return true ;
            
            default : return Character.isJavaIdentifierPart(c) ;
         }
      }
      
      @Override
      public boolean isWordPart(char c)
      {
         switch(c)
         {
            case '>':
            case '<':
            case '!':
            case '=': return true ;
            
            default : return Character.isJavaIdentifierPart(c) ;
         }
      }
   }
}