# Tools
Tools are objects that allow the user to perform a specific action using the editor. Only a single tool may be active at a time and tools should have their own user interface to provide feedback to the user. Tools are displayed in the toolbar.

The tools extension point(**org.osate.ge.tools**) is used to register tools. The graphical editor implements tool extensions which may be used as examples. Those tools are contained in the **org.osate.ge.internal.ui.tools**> package.

**NOTE: The tool extension point is currently limited to internal use only. The tools implemented by the graphical editor makes us of internal interfaces which are not API. The tools extension point should not be used at this time.**

## Required Annotations:
* Activate
* Deactivate
* Description
* Id
* Description
* Icon

## Optional Annotations:
* CanActivate
* SelectionChanged
