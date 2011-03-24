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
      // [DEBUG][TMP]
//      if(errManager.getNumErrors() == 0)
      {
         Iterator it = annexElements.iterator() ;
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