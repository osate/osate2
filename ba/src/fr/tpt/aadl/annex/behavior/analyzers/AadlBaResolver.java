package fr.tpt.aadl.annex.behavior.analyzers ;

import java.util.Iterator ;
import java.util.List ;

import edu.cmu.sei.aadl.aadl2.ComponentClassifier ;
import edu.cmu.sei.aadl.annex.AnnexResolver ;
import edu.cmu.sei.aadl.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex ;

public class AadlBaResolver implements AnnexResolver
{
   @SuppressWarnings("unchecked")
   @Override
   public void resolveAnnex(String annexName, List annexElements,
                            AnalysisErrorReporterManager errManager)
   {
      System.out.println("BEGIN BA RESOLVER ***********") ;

      Iterator it = annexElements.iterator() ;
      BehaviorAnnex ba ;
      ComponentClassifier pc ;
      AadlBaNameResolver nameResolver ;
      AadlBaSemanticRulesChecker semanticChecker;
      AadlBaLegalityRulesChecker legalityChecker;
      
      while(it.hasNext())
      {
         boolean result = false ;
         ba = (BehaviorAnnex) it.next() ;
         pc = AadlBaVisitors.getParentComponent(ba) ;
         nameResolver = new AadlBaNameResolver(ba, errManager) ;
         

         System.out.println("----- begin name resolution for " + pc.getName()
               + " ---- ") ;

         result = nameResolver.resolveNames() ;
            
         System.out.println("number of error : " + errManager.getNumErrors()) ;
         System.out.println("----- end of name resolution ---- ") ;
         
         if (result)
         {
            
            System.out.println("----- begin semantic analysis for " + 
                  pc.getName() + " ---- ") ;
            semanticChecker = new AadlBaSemanticRulesChecker(ba, errManager);
            semanticChecker.checkSemanticRules();
            System.out.println("number of error : " + errManager.getNumErrors());
            System.out.println("----- end semantic analysis for " + pc.getName()
                    + " ---- ") ;
         
            System.out.println("----- begin legality analysis for "+pc.getName()
                  + " ---- ") ;
            legalityChecker = new AadlBaLegalityRulesChecker(ba, errManager);
            legalityChecker.checkLegalityRules();
            System.out.println("number of error : " + errManager.getNumErrors());
            System.out.println("----- end legality analysis for " + pc.getName()
                  + " ---- ") ;
         }
      }

      System.out.println("END BA RESOLVER ***********") ;
      
   }
}  