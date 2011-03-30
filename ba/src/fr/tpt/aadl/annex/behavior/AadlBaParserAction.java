/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 Télécom ParisTech and CNRS
 * 
 * Télécom ParisTech/LTCI
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

import org.antlr.runtime.CharStream ;
import org.antlr.runtime.CommonTokenStream ;

import edu.cmu.sei.aadl.aadl2.AnnexLibrary ;
import edu.cmu.sei.aadl.aadl2.AnnexSubclause ;
import edu.cmu.sei.aadl.modelsupport.errorreporting.ParseErrorReporter ;
import fr.tpt.aadl.annex.behavior.parser.AadlBaLexer ;
import fr.tpt.aadl.annex.behavior.parser.AadlBaParser ;
import fr.tpt.aadl.annex.behavior.utils.CaseInsensitiveCharStream ;

public class AadlBaParserAction implements edu.cmu.sei.aadl.annex.AnnexParser
{

   public AnnexLibrary parseAnnexLibrary(
                                   String annexName,String source,
                                   String filename, int line, int column,
                                   ParseErrorReporter errReporter)
                                   throws org.antlr.runtime.RecognitionException
   {
      return null ;
   }

   public AnnexSubclause parseAnnexSubclause(
                                   String annexName, String source,
                                   String filename, int line, int column,
                                   ParseErrorReporter errReporter)
                                   throws org.antlr.runtime.RecognitionException
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
      return parser.behavior_annex() ;
   }
}