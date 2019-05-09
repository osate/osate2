This example loads an instance model and prints out its contents.  It does not understand any
annex extensions (all annexes are processed as text).

The examples takes a single instance model .aaxl file as input.

When run, the program
1. Loads the instance model
2. Prints out all the nodes in the model.


To run in the Eclipse environment (but as a stand-alone, non-eclipse application):
1. Select "Import..." in the Package Explorer context menu.
2. Select "Run/Debug" > "Launch Configuration"
3. Click on "Next >"
4. Choose "LoadInstanceModel.launch"
5. Click on "Finish"

You can now run the application from the Eclipse "Run" menu in the toolbar.


To run outside of Eclipse you must export the jar file:
1. Select "Export..." in the Package Explorer context menu
2. Select "Java" > "Runnable JAR file"
3. Click on "Next >"
4. Select the launch configuration "LoadInstanceModel"
5. Enter the path of the JAR file to create.
6. Select "Copy required libraries into a sub-folder next to the generated JAR"
7. Click on "Finish"

The JAR file will be created in the specified location.  A folder with the "_lib" suffix will also be generated
and all the needed libraries will be copied into it.

You can execute the the example now from the command line by going to its directory and, 
assuming you called the jar file LoadInstanceModel.jar, running

	java -jar LoadInstanceModel.jar <an instance .aaxl file>
	
