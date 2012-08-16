package fr.tpt.aadl.annex.behavior.texteditor;

import org.antlr.runtime.Token;

public class DefaultAadlBaHighlighter implements AadlBaHighlighter
{
  @Override
  public void addToHighlighting(int annexOffset, Token token, String id)
  {
    // Does nothing.
  }

  @Override
  public void addToHighlighting(int annexOffset, int relativeOffset, int length,
		String id) 
  {
	// Does nothing.
	
  }

}
