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

package org.osate.ba;

import org.antlr.v4.runtime.CharStream ;
import org.antlr.v4.runtime.CommonTokenStream ;
import org.eclipse.core.runtime.Platform ;
import org.osate.aadl2.AnnexLibrary ;
import org.osate.aadl2.AnnexSubclause ;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter ;
import org.osate.annexsupport.AnnexParser ;
import org.osate.annexsupport.AnnexUtil ;
import org.osate.ba.aadlba.AadlBaFactory ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.parser.AadlAntlrErrorReporter ;
import org.osate.ba.parser.AadlBaLexer ;
import org.osate.ba.parser.AadlBaParser ;
import org.osate.ba.parser.AadlBaParserVisitor ;
import org.osate.ba.parser.AadlBaParser.Behavior_annexContext ;
import org.osate.ba.texteditor.AadlBaHighlighter ;
import org.osate.ba.texteditor.DefaultAadlBaHighlighter ;
import org.osate.ba.texteditor.XtextAadlBaHighlighter ;
import org.osate.ba.utils.AadlBaLocationReference ;
import org.osate.ba.utils.CaseInsensitiveCharStream ;


public class AadlBaParserAction implements AnnexParser
{
   public static final String ANNEX_NAME = "behavior_specification";
   
   public AnnexLibrary parseAnnexLibrary(
                                   String annexName,String source,
                                   String filename, int line, int column,
                                   ParseErrorReporter errReporter)
                                   throws antlr.RecognitionException
   {
      return null ;
   }

   public AnnexSubclause parseAnnexSubclause(
                                   String annexName, String source,
                                   String filename, int line, int column,
                                   ParseErrorReporter errReporter)
                                   throws antlr.RecognitionException
   {
      if(false == ANNEX_NAME.equalsIgnoreCase(annexName))
      {
        return null ;
      }
     
      CharStream cs = new CaseInsensitiveCharStream(source) ;
      
      // AnnexOffset is the offset of the first token found in String source
      // considering the whole source file.
      int annexOffset = column ;
      
      AadlBaHighlighter highlighter ;
      // Set a Xtext highlighter if AADLBA Front End is running under OSATE2.
      if(Platform.isRunning())
      {
        highlighter = XtextAadlBaHighlighter.getHighlighter(AnnexUtil.getCurrentAnnexSubclause()) ;
      }
      else
      {
        // Default highlighter does nothing.
        highlighter = new DefaultAadlBaHighlighter() ;
      }
      
      AadlAntlrErrorReporter parserErrorReporter = 
                            new AadlAntlrErrorReporter(errReporter, filename) ;
      
      AadlBaLexer lexer = new AadlBaLexer(cs) ;
      lexer.setLine(line) ;
      lexer.setCharPositionInLine(column) ;
      lexer.removeErrorListeners() ;
      lexer.addErrorListener(parserErrorReporter) ;
      lexer.setHighlighter(highlighter) ;
      lexer.setAnnexOffset(annexOffset) ;
      
      CommonTokenStream tokens = new CommonTokenStream(lexer) ;
      
      AadlBaParser parser = new AadlBaParser(tokens) ;
      parser.removeErrorListeners() ;
      parser.addErrorListener(parserErrorReporter) ;
      
      try
      {
        // Build the primary AST: AST without AADLBA or declarative meta objects 
        // Instanced.
        Behavior_annexContext bac = parser.behavior_annex() ;
        BehaviorAnnex ba = null ;
        // Perform primary checking. Escape on error.
        
        if(parser.getNumberOfSyntaxErrors() == 0)
        {
          AadlBaParserVisitor<Boolean> visitor = 
                new AadlBaParserVisitor<Boolean>(filename, annexOffset) ;
          
          visitor.visit(bac) ;
          
          ba = bac.result ;
        }
        else
        {
          // Create an empty behavior annex object in order to
          // highlight keywords even if there is some syntax errors.
          ba = AadlBaFactory.eINSTANCE.createBehaviorAnnex();
        }
        
        if(ba != null)
        {
          AadlBaLocationReference location =
              new AadlBaLocationReference(annexOffset, filename, line) ;
        
          location.setOffset(0) ;
          ba.setLocationReference(location) ;
        }
        
        return ba ;
      }
      // Translates ANTLR runtime exception to ANTLR Exception. 
      catch(org.antlr.v4.runtime.RecognitionException e)
      {
        int errLine = e.getOffendingToken().getLine() ;
        int errColumn = e.getOffendingToken().getCharPositionInLine() ;
        
        throw new antlr.RecognitionException(e.getMessage(),
                                             filename,
                                             errLine,
                                             errColumn) ;
      }
      catch(IllegalArgumentException e)
      {
        // Nothing to do as the parser is supposed to report any error.
        // DEBUG
        e.printStackTrace() ;
        return null ;
      }
   }
}