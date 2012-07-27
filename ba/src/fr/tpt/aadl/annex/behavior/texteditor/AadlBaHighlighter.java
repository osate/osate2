package fr.tpt.aadl.annex.behavior.texteditor;

import org.antlr.runtime.Token;

public interface AadlBaHighlighter
{
  public void addToHighlighting(Token token, String id) ;
  
  public void highlightNow() ;
}