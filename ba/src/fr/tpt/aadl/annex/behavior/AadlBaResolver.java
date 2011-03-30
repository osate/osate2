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

import java.util.Iterator ;
import java.util.List ;

import edu.cmu.sei.aadl.annex.AnnexResolver ;
import edu.cmu.sei.aadl.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex ;
import fr.tpt.aadl.annex.behavior.analyzers.AadlBaNameResolver ;
import fr.tpt.aadl.annex.behavior.analyzers.AadlBaRulesCheckersDriver ;
import fr.tpt.aadl.annex.behavior.analyzers.AadlBaTypeChecker ;
import fr.tpt.aadl.annex.behavior.analyzers.AdaLikeDataTypeChecker ;
import fr.tpt.aadl.annex.behavior.analyzers.DataTypeChecker ;

public class AadlBaResolver implements AnnexResolver
{
   @SuppressWarnings("unchecked")
   @Override
   public void resolveAnnex(String annexName, List annexElements,
                            AnalysisErrorReporterManager errManager)
   {
      // Can't resolve behavior annex if there are AADL errors.
      if(errManager.getNumErrors() == 0)
      {
         Iterator<?> it = annexElements.iterator() ;
         BehaviorAnnex ba ;
         AadlBaNameResolver nameResolver ;
         AadlBaRulesCheckersDriver semanticAnalysis;
         AadlBaTypeChecker typeChecker ;
         DataTypeChecker dataTypeChecker = new AdaLikeDataTypeChecker(
                                                                   errManager) ;
         
         while(it.hasNext())
         {
            boolean result = false ;
            ba = (BehaviorAnnex) it.next() ;
            nameResolver = new AadlBaNameResolver(ba, errManager) ;
            
            result = nameResolver.resolveNames() ;
            
            // It doesnt't perform semantic tests if the name resolution has
            // failed. 
            if (result)
            {
               
               typeChecker = new AadlBaTypeChecker(ba, dataTypeChecker,
                                                       errManager) ;
               typeChecker.checkTypes() ;
                  
               semanticAnalysis = new AadlBaRulesCheckersDriver(ba, errManager);
               semanticAnalysis.process(ba) ;
            }
         }
      }
   }
}  