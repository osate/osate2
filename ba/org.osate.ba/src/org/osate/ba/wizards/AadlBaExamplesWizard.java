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

package org.osate.ba.wizards;

import java.io.File ;
import java.util.List ;

import org.eclipse.core.runtime.IPath ;
import org.osate.utils.FileUtils ;


public class AadlBaExamplesWizard extends AadlBaAbstractWizard
{

  @Override
  public boolean performFinish()
  {
    boolean result = super.performFinish() ;
    
    if(result)
    {
      try
      {
        List<File> selectedExamples =
                      this.fetchSelectedExamples(_SelectedExamplesTreeContent) ;
        if(!selectedExamples.isEmpty())
        {
          IPath projectPath = this.newProject.getLocation() ;

          File destFolder =
                new File(projectPath.toString() + IPath.SEPARATOR +
                      _EXAMPLE_ROOT_PATH) ;
          destFolder.mkdir() ;
          
          FileUtils.copyFiles(selectedExamples, destFolder,
                              _EXCLUDED_DIRECTORIES) ;
          
          this.newProject.refreshLocal(2, null) ;
        }
      }
      catch (Exception e)
      {
        result = false ;
        reportError("Save examples problem", e) ;
      }
    }
    
    return result ;
  }
  
}