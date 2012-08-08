/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.annex.behavior ;

import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.CharStream ;
import org.antlr.runtime.CommonTokenStream ;
import org.eclipse.core.runtime.Platform ;

import antlr.RecognitionException;

import org.osate.aadl2.AnnexLibrary ;
import org.osate.aadl2.AnnexSubclause ;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter ;
import org.osate.annexsupport.AnnexHighlighterPositionAcceptor ;
import org.osate.annexsupport.AnnexParser;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.annex.behavior.parser.AadlBaLexer ;
import fr.tpt.aadl.annex.behavior.parser.AadlBaParser ;
import fr.tpt.aadl.annex.behavior.texteditor.AadlBaHighlighter ;
import fr.tpt.aadl.annex.behavior.texteditor.DefaultAadlBaHighlighter ;
import fr.tpt.aadl.annex.behavior.texteditor.XtextAadlBaHighlighter ;
import fr.tpt.aadl.annex.behavior.utils.CaseInsensitiveCharStream ;

public class AadlBaParserAction implements AnnexParser
{
   public static final String ANNEX_NAME = "behavior_specification";
   
   public AnnexLibrary parseAnnexLibrary(
                                   String annexName,String source,
                                   String filename, int line, int column,
                                   ParseErrorReporter errReporter)
                                   throws RecognitionException
   {
      return null ;
   }

   public AnnexSubclause parseAnnexSubclause(
                                   String annexName, String source,
                                   String filename, int line, int column,
                                   ParseErrorReporter errReporter)
                                   throws RecognitionException
   {
      ParseErrorReporter reporter = errReporter ;
      CharStream cs = new CaseInsensitiveCharStream(source) ;
      cs.setLine(line) ;
      cs.setCharPositionInLine(column) ;
      AadlBaLexer lexer = new AadlBaLexer(cs) ;
      lexer.setParseErrorReporter(reporter) ;
      lexer.setFilename(filename) ;
      CommonTokenStream tokens = new CommonTokenStream(lexer) ;
      // Necessary but why ???
      tokens.toString() ;
      AadlBaParser parser = new AadlBaParser(tokens) ;
      parser.setParseErrorReporter(reporter) ;
      parser.setFilename(filename) ;
      
      AadlBaHighlighter highlighter ;
      
      // Set a Xtext highlighter if AADLBA Front End is running under OSATE2.
      if(Platform.isRunning())
      {
        highlighter = new XtextAadlBaHighlighter() ;
      }
      else
      {
        // Default highlighter does nothing.
        highlighter = new DefaultAadlBaHighlighter() ;
      }
      
      parser.setHighlighter(highlighter) ;
      
      try
      {
         BehaviorAnnex ba = parser.behavior_annex() ;
         ba.getLocationReference().setOffset(column);
         ba.getHighlighters().put(ba, highlighter);
         return ba ;
      }
      // Translates ANTLR runtime exception to ANTLR Exception. 
      catch(org.antlr.runtime.RecognitionException e)
      {
         throw new RecognitionException(e.getMessage(),
                                        filename,
                                        e.line,
                                        e.charPositionInLine) ;
      }
      catch(IllegalArgumentException e)
      {
         // Nothing to do as the parser is supposed to report any error.
         return null ;
      }
   }
}