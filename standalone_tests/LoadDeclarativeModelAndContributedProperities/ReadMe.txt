This example loads multiple declarative and instance models and prints out their contents.  This version manually
registers the contributed resources AADL_Project and Programming_Properties.  The input models may make use of those
property sets.

The example takes 1 or more declarative or instances files as input.

When run, the program
1. Loads the contributed resources
1. Loads the declarative and instance models
2. Validates the models (including the contributed resources), printing out any validation messages
3. Prints out all the nodes in each model.


The directory "aadl_files" contains several declarative files.  Of interest are
- Debug.aadl - A "local" property set
- test.aadl - a model that uses properties from Debug and from Programming_Properties

Running this example from Eclipse doesn't make sense, but you still need the run configuration
so that you can export the jar file.
1. Select "Import..." in the Package Explorer context menu.
2. Select "Run/Debug" > "Launch Configuration"
3. Click on "Next >"
4. Choose "LoadDeclarativeModelAndContributedProperties.launch"
5. Click on "Finish"

To run outside of Eclipse you must export the jar file:
1. Select "Export..." in the Package Explorer context menu
2. Select "Java" > "Runnable JAR file"
3. Click on "Next >"
4. Select the launch configuration "LoadDeclarativeModelAndContributedProperties"
5. Enter the path of the JAR file to create.
6. Select "Copy required libraries into a sub-folder next to the generated JAR"
7. Click on "Finish"

The JAR file will be created in the specified location.  A folder with the "_lib" suffix will also be generated
and all the needed libraries will be copied into it.

To run this example you must copy the jar file for the "org.osate.workspace" plug-in to the same directory as the
exported jar file.  Then you need to create an "aadl_files" directory in the same location.  Put the model files
you want to load in the aadl_files directory.

You can execute the example, assuming you called the jar file
LoadDeclarativeModelAndContributedProperties.jar, by running

	java -cp "./LoadDeclarativeModelAndContributedProperties.jar;./org.osate.workspace_1.0.0.v20180511-1311.jar"
	    org.osate.standalone.emf.LoadDeclarativeModelAndContributedProperties
	    foo/test.aadl foo/Debug.aadl foo/test1.aadl
	
NOTE: "foo" is correct.  The example program maps a project called "foo" to the directory "aadl_files"


ALSO NOTE: There is a log4j.properties file that is used to shut off some annoying and useless messages from the
Xtext internals.

