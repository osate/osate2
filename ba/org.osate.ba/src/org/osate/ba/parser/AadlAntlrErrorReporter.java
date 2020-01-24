/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2013 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * https://www.eclipse.org/legal/epl-2.0/
 */

package org.osate.ba.parser;

import java.util.Arrays ;

import org.antlr.v4.runtime.BaseErrorListener ;
import org.antlr.v4.runtime.InputMismatchException ;
import org.antlr.v4.runtime.NoViableAltException ;
import org.antlr.v4.runtime.RecognitionException ;
import org.antlr.v4.runtime.Recognizer ;
import org.antlr.v4.runtime.Token ;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter ;
import org.osate.utils.Aadl2Utils ;


public class AadlAntlrErrorReporter extends BaseErrorListener
{
  protected final ParseErrorReporter _errReporter ;
  
  protected final String _filename ; 
  
  public AadlAntlrErrorReporter(ParseErrorReporter errReporter,
                                   String filename)
  {
    _errReporter = errReporter ;
    _filename = filename ;
  }
  
  @Override
  public void syntaxError(Recognizer<?, ?> recognizer,
                          Object offendingSymbol,
                          int line,
                          int charPositionInLine,
                          String msg,
                          RecognitionException e)
  {
    if(e instanceof NoViableAltException || e instanceof InputMismatchException)
    {
      if(isKeywordError(offendingSymbol, e))
      {
        msg = "symbol not allowed at input \'" +
              ((Token)offendingSymbol).getText() +  
              "\', reserved symbol" ;
      }
    }
    
    _errReporter.error(_filename, line, msg) ;
  }
  
  protected boolean isKeywordError(Object offendingSymbol,
                                   RecognitionException ex)
  {
    Token symb = (Token) offendingSymbol ;
    
    if(symb.getType() <= AadlBaLexer.KEYWORD_MAX_ID) // Select only keyword.
    {
      String symbol = '\'' + symb.getText() + '\'' ;
      return Aadl2Utils.contains(symbol, Arrays.asList(AadlBaLexer.tokenNames)) ;
    }
    else
    {
      return false ;
    }
  }
}