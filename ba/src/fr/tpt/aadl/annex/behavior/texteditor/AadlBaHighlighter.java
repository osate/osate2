package fr.tpt.aadl.annex.behavior.texteditor;

import org.antlr.runtime.Token;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;

public interface AadlBaHighlighter
{
  public void addToHighlighting(BehaviorAnnex annex, Token token, String id) ;
  
}