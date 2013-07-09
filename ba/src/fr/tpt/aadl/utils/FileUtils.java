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
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.utils;

import java.io.File ;
import java.io.FileFilter ;
import java.io.IOException ;
import java.util.List ;

import org.osate.workspace.WorkspacePlugin ;

import com.google.common.io.Files ;

public class FileUtils
{
  /**
   * Provides filter for AADL files (either .aadl or .aadl2).  
   */
  public static class AadlFileFilter implements FileFilter
  {
    @Override
    public boolean accept(File pathname)
    {
      String fileName = pathname.getName() ;
      
      int i = fileName.lastIndexOf('.') ;
      
      String extension = fileName.substring(i+1, fileName.length()) ;
      
      return WorkspacePlugin.SOURCE_FILE_EXT.equalsIgnoreCase(extension) ||
             WorkspacePlugin.SOURCE_FILE_EXT2.equalsIgnoreCase(extension) ;
    }
  }
  
  /**
   * Recursive copy the given source node to the given destination directory.<BR>
   * Create destination directory if it doesn't exist.<BR>
   * Overwriting destination is not permitted. If the given list of node's name 
   * (just file or directory name, not absolute path) is not {@code null}, 
   * The nodes from the given source directory, which name appears in the given
   * list (case not sensitive), will not be copied.
   * 
   * @param srcFile the given source node
   * @param destFolder the given destination directory
   * @param excludedNodeNames list of node's names not copied or {@code null}.
   * @throws IOException for any read or write errors
   */
  public static void copyFiles(File srcFile, File destFolder,
                               List<String> excludedNodeNames) throws IOException
  {
    // Verifications
    byte errorCode = 0 ;
    
    if(Aadl2Utils.contains(srcFile.getName(), excludedNodeNames))
    {
      return ;
    }
    
    if(! srcFile.exists())
    {
      errorCode += 1 ;
    }
    
    if(destFolder.exists() && destFolder.isFile())
    {
      errorCode += 10 ;
    }
    
    if(errorCode != 0)
    {
      String errorMsg = "" ;
      
      switch(errorCode)
      {
        case 11  : errorMsg = "destination is not a directory, can overwrite it and " ;
        case 1   : { errorMsg = "source file doesn't exist"  ; break ;}
        case 10  : {errorMsg = "destination is not a directory, can overwrite it" ; break;}
      }
      
      throw new IOException(errorMsg) ;
    }
    
    if(! destFolder.exists())
    {
      destFolder.mkdirs() ;
    }
    
    if(srcFile.isDirectory())
    {
      for(File inside : srcFile.listFiles())
      {
        File newDestFolder = new File(destFolder.getPath() + File.separatorChar + 
                                      srcFile.getName()) ;
        newDestFolder.mkdir() ;
        
        FileUtils.copyFiles(inside, newDestFolder, excludedNodeNames) ;
      }
    }
    else
    {
      File newFile = new File(destFolder.getPath() + File.separatorChar + 
                                                     srcFile.getName()) ;
      
      Files.copy(srcFile, newFile) ;
    }
  }
  
  /**
   * Recursive copy the given list of source nodes to the given destination
   * directory.<BR>
   * Create destination directory if it doesn't exist.<BR>
   * Overwriting destination is not permitted. If the given list of node's name 
   * (just file or directory name, not absolute path) is not {@code null}, 
   * The nodes from the given source directory, which name appears in the given
   * list (case not sensitive), will not be copied.
   * 
   * @param srcFiles the given list of source nodes
   * @param destFolder the given destination directory
   * @param excludedNodeNames list of node's names not copied or {@code null}.
   * @throws IOException for any read or write errors
   */
  public static void copyFiles(List<File> srcFiles, File destFolder,
                               List<String> excludedNodeNames) throws IOException
  {
    for(File f : srcFiles)
    {
      FileUtils.copyFiles(f, destFolder, excludedNodeNames) ;
    }
  }
  
  /**
   * Delete the given File object. If the object represents a directory, it 
   * recursively deletes the directory and its contains.
   * 
   * @param toBeDelete the given File object.
   */
  public static void deleteFile (File toBeDelete)
  {
    delete(toBeDelete, true) ;
  }
  
  /**
   * Delete the contain of the given directory without delete the directory
   * itself.
   * 
   * @param directory the given directory
   */
  public static void deleteDirectoryContain(File directory)
  {
    delete(directory, false) ;
  }
  
  private static void delete (File toBeDelete, boolean justTheContain)
  {
    if(toBeDelete.exists())
    {
      if(toBeDelete.isDirectory())
      {
        for(File f : toBeDelete.listFiles())
        {
          // Recursive call.
          FileUtils.deleteFile(f) ;
        }
      }
      
      if (justTheContain)
      {
        toBeDelete.delete() ;
      }
    }
  }
}