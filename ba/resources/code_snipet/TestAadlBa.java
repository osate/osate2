import java.io.IOException ;

import org.antlr.runtime.ANTLRStringStream ;
import org.antlr.runtime.CharStream ;
import org.antlr.runtime.CommonTokenStream ;
import org.antlr.runtime.RecognitionException ;
import org.antlr.runtime.Token ;
import org.antlr.runtime.tree.CommonTree ;
import org.antlr.runtime.tree.CommonTreeAdaptor ;
import org.antlr.runtime.tree.TreeAdaptor ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl ;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl ;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaFactory ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex ;
import fr.tpt.aadl.annex.behavior.aadlba.Comment ;
import fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaFactoryImpl ;

public class TestAadlBa
{

   /**
    * @param args
    */
   public static void main(String[] args)
   {
      // TODO Auto-generated method stub

      // ANTLRInputStream input = new ANTLRInputStream(System.in);
      // ExprLexer lexer = new ExprLexer(input);
      // CommonTokenStream tokens = new CommonTokenStream(lexer);
      // ExprParser parser = new ExprParser(tokens);
      // ExprParser.prog_return r = parser.prog();

      String source =
            "variables tmp : number ; states s : initial final state; transitions t : s -[]-> s { mul!(x,x,tmp); mul!(tmp,x,y) };" ;

      CharStream cs = new ANTLRStringStream(source) ;

      AadlBaLexer lexer = new AadlBaLexer(cs) ;

      CommonTokenStream tokens = new CommonTokenStream(lexer) ;
      AadlBaParser parser = new AadlBaParser(tokens) ;
      
      BehaviorAnnex ba = null ;
      
      try
      {
         ba = parser.behavior_annex() ;
      }
      catch(RecognitionException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace() ;
      }
      
      AadlBaFactory factory = AadlBaFactoryImpl.init() ;
      
      Comment comment = factory.createComment() ;
      
      // create resource set and resource
      ResourceSet resourceSet = new ResourceSetImpl() ;

      resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
            "xmi", new XMIResourceFactoryImpl()) ;

      Resource resource =
            resourceSet
                  .createResource(URI.createFileURI("test.xmi")) ;

      // add the root object to the resource
      resource.getContents().add(ba) ;

      // serialize resource – you can specify also serialization
      // options which defined on org.eclipse.emf.ecore.xmi.XMIResource
      try
      {
         resource.save(null) ;
      }
      catch(IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
}

