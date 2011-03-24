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

import java.io.IOException ;

import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl ;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl ;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaFactory ;
import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage ;
import fr.tpt.aadl.annex.behavior.aadlba.Comment ;
import fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaFactoryImpl ;

public class Ecore2XmlTest
{

   final static String FILE_NAME = "test.xmi" ;

   final static String XML_SCHEME = "xmi" ;

   /**
    * @param args
    */
   public static void main(String[] args)
   {
      serialize() ;
      deserialize() ;
   }

   public static void serialize()
   {
      AadlBaFactory factory = AadlBaFactoryImpl.init() ;

      Comment comment = factory.createComment() ;

      comment.setBody("coucou") ;

      // create resource set and resource
      ResourceSet resourceSet = new ResourceSetImpl() ;

      resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
            XML_SCHEME, new XMIResourceFactoryImpl()) ;

      Resource resource =
            resourceSet.createResource(URI.createFileURI(FILE_NAME)) ;

      // add the root object to the resource
      resource.getContents().add(comment) ;

      // serialize resource – you can specify also serialization

      // options which defined on org.eclipse.emf.ecore.xmi.XMIResource
      try
      {
         resource.save(null) ;
      }
      catch(IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace() ;
      }
   }

   public static void deserialize()
   {
      // create resource set and resource
      ResourceSet resourceSet = new ResourceSetImpl() ;

      resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
            "xmi", new XMIResourceFactoryImpl()) ;

      resourceSet.getPackageRegistry().put(AadlBaPackage.eINSTANCE.getNsURI(),
            AadlBaPackage.eINSTANCE) ;
      Resource resource =
            resourceSet.createResource(URI.createFileURI(FILE_NAME)) ;

      // load resource
      try
      {
         resource.load(null) ;
      }
      catch(IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace() ;
      }

      for(EObject o : resource.getContents())
      {
         System.out.println("Object deserialized : " + o.toString()) ;
      }

   }
}
