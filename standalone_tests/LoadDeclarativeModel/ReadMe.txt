This example loads multiple declarative models and prints out their contents.  It does not understand any
annex extensions (all annexes are processed as text).

The examples takes 1 or more declarative files as input.

When run, the program
1. Loads the declarative models
2. Validates the declarative models, printing out any validation messages
3. Prints out all the nodes in each model.


The directory "aadl_files" contains 3 declarative files:
- ComponentImplementations.aadl contains several component classifiers and doesn't make use of any annex specifications.
- fred2.aadl contains an EMV2 error model specification.
- test.aadl contains a bogus annex specification for the annex type "fake".

The point here is that if you load fred2.aadl and test.aadl you will see that the annex contains
are just stored as a giant string in the annex parse node.



To run in the Eclipse environment (but as a stand-alone, non-eclipse application):
1. Select "Import..." in the Package Explorer context menu.
2. Select "Run/Debug" > "Launch Configuration"
3. Click on "Next >"
4. Choose "LoadDeclarativeModel.launch"
5. Click on "Finish"

You can now run the application from the Eclipse "Run" menu in the toolbar.


To run outside of Eclipse you must export the jar file:
1. Select "Export..." in the Package Explorer context menu
2. Select "Java" > "Runnable JAR file"
3. Click on "Next >"
4. Select the launch configuration "LoadDeclarativeModel"
5. Enter the path of the JAR file to create.
6. Select "Copy required libraries into a sub-folder next to the generated JAR"
7. Click on "Finish"

The JAR file will be created in the specified location.  A folder with the "_lib" suffix will also be generated
and all the needed libraries will be copied into it.

You can execute the the example now from the command line by going to its directory and, 
assuming you called the jar file LoadDeclarativeModel.jar, running

	java -jar LoadDeclarativeModel.jar <one or more declarative .aadl files>
	
