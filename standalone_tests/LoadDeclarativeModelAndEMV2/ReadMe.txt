This example loads multiple declarative models and prints out their contents.  This version uses the 
EMV2 extension to parse EMV2 error model annexes.  More specifically, the EMV2 extension is registered
by reading the the plugin.xml file from the errormodel plug-in.

The examples takes 1 or more declarative files as input.

When run, the program
1. Loads the declarative models
2. Validates the declarative models, printing out any validation messages
3. Prints out all the nodes in each model.


The directory "aadl_files" contains 3 declarative files:
- ComponentImplementations.aadl contains several component classifiers and doesn't make use of any annex specifications.
- fred2.aadl contains an EMV2 error model specification.
- test.aadl contains a bogus annex specification for the annex type "fake".

The point here is that if you load fred2.aadl you will see that the error model is parsed into ErrorType nodes.  No extension
is registered to handle the "fake" annex, so that remains processed as a giant text string.



To run in the Eclipse environment (but as a stand-alone, non-eclipse application):
1. Select "Import..." in the Package Explorer context menu.
2. Select "Run/Debug" > "Launch Configuration"
3. Click on "Next >"
4. Choose "LoadDeclarativeModelAndEMV2.launch"
5. Click on "Finish"

You can now run the application from the Eclipse "Run" menu in the toolbar.


To run outside of Eclipse you must create that JAR file using an ANT script.  This is because the standard
Eclipse export procedure does not include the MANIFEST.MF and plugin.xml files that we need. 

1. Right click on the file "jar-it.xml" in the root of the project.
2. Select "Run As > Ant Bulid" in the context menu.
3. A JAR "LoadDeclarativeModelAndEMV2.jar" and a directory "LoadDeclarativeModelAndEMV2_lib" will be created
   in the "executable" directory.  You will probably have to refresh the project in the Package Exploroer to see
   them.
4. Copy the JAR and the "_lib" directory to wherever you want to put the stand-alone program.


You can execute the the example now from the command line by going to its directory and, 
assuming you called the jar file LoadDeclarativeModelAndEMV2.jar, running

	java -jar LoadDeclarativeModelAndEMV2.jar <one or more declarative .aadl files>



--------------------------------

The jar file must be built from an ANT script to force the plugin.xml and MANIFEST.MF files from the
org.osate.annexsupport and org.osate.xtext.aadl2.errormodel plug-ins to be in the JAR.


How the Ant build file was generated:

1. Select "Export..." in the Package Explorer context menu
2. Select "Java" > "Runnable JAR file"
3. Click on "Next >"
4. Select the launch configuration "LoadDeclarativeModelAndEMV2"
5. Enter the path of the JAR file to create.
6. Select "Copy required libraries into a sub-folder next to the generated JAR"
7. Check "Save as ANT Script" and enter a name for the script. 
7. Click on "Finish"
8. Edit the newly generated ANT script.
9. We need to modify the script so that the plug-in.xml and MANIFEST.MF files are copied to the "_lib" directory.  Add
   the following subtasks to the end of the target:
   
		<copy file="C:/Users/aarong/git/osate2/core/org.osate.annexsupport/plugin.xml" todir="${dir.jarfile}/LoadDeclarativeModelAndEMV2_lib/org.osate.annexsupport/" />
      	<copy file="C:/Users/aarong/git/osate2/core/org.osate.annexsupport/META-INF/MANIFEST.MF" todir="${dir.jarfile}/LoadDeclarativeModelAndEMV2_lib/org.osate.annexsupport/META-INF"/>
       	<copy file="C:/Users/aarong/git/osate2/emv2/org.osate.xtext.aadl2.errormodel/plugin.xml" todir="${dir.jarfile}/LoadDeclarativeModelAndEMV2_lib/org.osate.xtext.aadl2.errormodel" />
       	<copy file="C:/Users/aarong/git/osate2/emv2/org.osate.xtext.aadl2.errormodel/META-INF/MANIFEST.MF" todir="${dir.jarfile}/LoadDeclarativeModelAndEMV2_lib/org.osate.xtext.aadl2.errormodel/META-INF" />

    Replace "C:/Users/aarong/git/osate2/" with the path to your osate2 git clone.
10. We need to update the classpath to point to our org.osate.annexsupport and org.osate.xtext.aadl2.errormodel directories:

        <attribute name="Class-Path" value=". LoadDeclarativeModelAndEMV2_lib/org.osate.annexsupport/
        LoadDeclarativeModelAndEMV2_lib/org.osate.xtext.aadl2.errormodel/ ... />
        
11. Make sure that the location of hte jarfile is the "executable" directory in the project:

    <property name="dir.jarfile" value="${dir.buildfile}/executable"/>
    
