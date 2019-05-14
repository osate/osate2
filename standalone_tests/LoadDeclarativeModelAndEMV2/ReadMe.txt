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


To run outside of Eclipse you must export the jar file:
1. Select "Export..." in the Package Explorer context menu
2. Select "Java" > "Runnable JAR file"
3. Click on "Next >"
4. Select the launch configuration "LoadDeclarativeModelAndEMV2"
5. Enter the path of the JAR file to create.
6. Select "Copy required libraries into a sub-folder next to the generated JAR"
7. Click on "Finish"

The JAR file will be created in the specified location.  A folder with the "_lib" suffix will also be generated
and all the needed libraries will be copied into it.

You will also need the plugin jar files for the org.osate.annexsupport and org.osate.xtext.aadl2.errormodel
plug-ins.  You can get these from an OSATE installer or from the OSATE p2 repository.  The plugin jar files
must be added to the classpath of the example, so cannot use the "-jar" option to the JVM.  Instead you must
list all the jar files on the classpath and then name of the main class explicitly.  It doesn't matter where
you locate the plugin jars, but the "_lib" directory must be in the same location as the exported jar.

Using PowerShell on windows you need to put quotes around the classpath:

    java -cp ".\runit.jar;.\org.osate.annexsupport_1.0.0.v20190311-1415.jar;.\org.osate.xtext.aadl2.errormodel_1.0.0.v20190217-2022.jar" org.osate.standalone.emf.LoadDeclarativeModelAndEMV2 .\aadl_files\fred2.aadl


