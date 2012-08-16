package fr.tpt.aadl.annex.behavior.texteditor;

import org.antlr.runtime.Token;

public interface AadlBaHighlighter
{
  public void addToHighlighting(int annexOffset, Token token, String id) ;

  public void addToHighlighting(int annexOffset, int relativeOffset, int length, String id) ;
  
}