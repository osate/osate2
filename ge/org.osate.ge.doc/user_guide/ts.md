## Troubleshooting
The following section contains solutions to known issues as well as instructions for reporting problems with the graphical editor.

### Build Automatically
*Project->Build Automattically* must be enabled.  If it is not enabled, the graphical editor will not function properly.

![](images/BuildAutomatically.png)

### Inconsistent Font Sizes Across Machines
To ensure diagrams have a consistent appearance across machines, the graphical editor attempts to produce consistent text sizes regardless of system settings. However, due to limitations in the underlying libraries on which the graphical editor relies, this is not always possible. On windows systems, the graphical editor produces consistent font sizes at 100%, 125%, and 200% system text scaling levels.

### Out of Handles Exception
When working with extremely large models, the graphical editor may run out of graphics handles. To work around this issue, reduce the number of graphics handles used by splitting the model into smaller packages.

### Unable to Set Properties Unless Text Model is Open
The AADL Property Values view does not support editing property associations unless the textual AADL model is open. To work around this issue, open the textual AADL file before attempting to create property assignments with the AADL Properties Values view.

### Updating the Diagram
In most cases the graphical editor will automatically update diagrams to reflect changes to the AADL Model. If a diagram has not been updated for any reason, it can be updated manually by right-clicking inside an empty area of the diagram and selecting *Update* from the context menu.

### Reporting Bugs
Bugs should be reported to the issue tracker on the graphical editor's <a href="https://github.com/osate/osate-ge" target="_blank">GitHub Site</a>.

