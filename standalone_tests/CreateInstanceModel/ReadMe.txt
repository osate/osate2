This example loads a declarative model and then creates an instance model from it at
runtime.  The instance model is not persisted in any way.

The examples takes two arguments

1. The path of the declarative .aadl file to load
2. The name of the system instance to instantiate

When run, the program
1. Loads the declarative model
2. Looks for the named system instance in the model
3. Creates the instance model
4. Prints all the nodes in the instance model


To run in the Eclipse environment (but as a stand-alone, non-eclipse application):
1. Select "Import..." in the Package Explorer context menu.
2. Select "Run/Debug" > "Launch Configuration"
3. Click on "Next >"
4. Choose "CreateInstanceModel.launch"
5. Click on "Finish"

You can now run the application from the Eclipse "Run" menu in the toolbar.


To run outside of Eclipse you must export the jar file:
1. Select "Export..." in the Package Explorer context menu
2. Select "Java" > "Runnable JAR file"
3. Click on "Next >"
4. Select the launch configuration "CreateInstanceModel"
5. Enter the path of the JAR file to create.
6. Select "Copy required libraries into a sub-folder next to the generated JAR"
7. Click on "Finish"

The JAR file will be created in the specified location.  A folder with the "_lib" suffix will also be generated
and all the needed libraries will be copied into it.

You can execute the the example now from the command line by going to its directory and, 
assuming you called the jar file CreateInstanceModel.jar, running

	java -jar CreateInstanceModel.jar <path to declarative model> <name of classifier to instantiate>
	
