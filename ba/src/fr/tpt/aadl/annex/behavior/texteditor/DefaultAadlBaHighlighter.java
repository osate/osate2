package fr.tpt.aadl.annex.behavior.texteditor;

import org.antlr.runtime.Token;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;

public class DefaultAadlBaHighlighter implements AadlBaHighlighter
{
  @Override
  public void addToHighlighting(BehaviorAnnex annex, Token token, String id)
  {
    // Does nothing.
  }

}
