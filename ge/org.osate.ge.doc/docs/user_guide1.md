---
title: OSATE Graphical Editor User Guide
linkReferences: true
figPrefix:
- figure
- figures
tblPrefix:
- table
- tables
secPrefix:
- section
- sections
---

# Tutorial: Getting Started
## Create a New Project
1. Select *File->New->Other…->AADL->AADL Project*
2. Enter project name: MyFirstProject
3. Click *Finish*

## Create a New Package
make sure to add references to docs

1. Right-click MyFirstProject in the *AADL Navigator*
2. Select *New->Other…->AADL->AADL Package*
3. Enter package name: MyFirstPackage
4. Select *Diagram Editor*
5. Click *Finish*
6. Click *OK*




# Creating Model Elements
Most elements are created by selecting the desired element from the palette and placing it on the diagram.

## Creating Classifier Implementations
Select the desired implementation from the palette and place it on the diagram or on an eligible type.

## Creating Mode Transitions
Select *Mode Transition* from the palette and select the starting mode then the ending mode (See @sec:mode_transition).

## Creating Flow Implementations and End-To-End Flow Specifications
When editing a component implementation, flow implementations and end-to-end flow specifications can be created graphically by selecting the *Create Flow Implementation* and *Create End-To-End Flow Specification* tools from the toolbar and following the prompts to select a series of elements from the diagram (See @sec:ete_flow and @sec:flow_implmentation).

# Editing Model Elements

## Properties View{#sec:properties_view}
The properties sheet contains properties for the currently selected diagram elements. The properties sheet can be opened by 
double-clicking on a diagram element in the diagram or in the outline. Alternatively, the properties sheet can be opened by 
right-clicking on a diagram element in the diagram or outline and selecting *Properties…* from the context menu.

## Renaming
Elements can be renamed three ways:

1. Right click an element in the *Outline* view select *Rename…* from the context menu.
2. Right click an element on the diagram and select *Rename…* from the context menu.
3. Select an element on the diagram, then click and hover over the label.

## Deleting
Elements can be deleted three ways:

1. Right click an element in the *Outline* view select *Delete* from the context menu.
2. Right click an element on the diagram and select *Delete* from the context menu.
3. Selecting an element on the diagram and press the *Delete* key.

## Indirect Editing
To allow for easier editing, the editor allows editing classifiers in the context of related model elements. For example, a data port may 
be created inside a component implementation. Since AADL component implementations cannot contain data ports, the data port will be 
created inside the component implementation's type (See @sec:inherited_elements). In cases where there are multiple potential classifiers to edit, the editor will prompt to select a classifier.

## Setting the Initial Mode
A mode can be designated as the initial mode by using the *AADL* tab of the *Properties* view (See @sec:properties_view), and using the *Initial* section option.

## Arrays
A mode can be designated as the initial mode by using the *AADL* tab of the *Properties* view (See @sec:properties_view), and using the *Dimensions* section options.

|Menu Item                | Description                              |
|------------------|------------------------------------------|
| *Add* 					| Shows the *Modify Dimension* dialog to create a dimension. |
| *Modify...*                  | Shows the *Modify Dimension* dialog to make modifications to the selected dimension. |
| *Delete*                 | Deletes the selected dimension. |
| *Up* and *Down*                 | Changes the order of the dimensions. |

## Bindings
When editing a component implementation, binding property associations can be created by selecting the diagram element for which to set the binding, then selecting the *Bind...* button from the toolbar (See @sec:binding).

## Editing Flow Implementations and End-to-End Flows
When editing a component implementation, flow implementations and end-to-end flow can be edited using the flow editor.  The flow editor can be accessed by double-clicking the component implementation, selecting the *AADL* tab in the *Properties* view, and selecting *Edit...* from the *Flows* section.

## Refining
Appropriate elements can be refined by using the *AADL* tab of the *Properties* view (See @sec:properties_view), and using the *Refined* section option.

## Selecting Active Components{#sec:selective_active_components}
Modes can be specified for selected element(s) by using the *AADL* tab of the *Properties* view (See @sec:properties_view), and using the *In Modes* section options.

## Editing Subprogram Call Sequences
The subprogram call's order in the subprogram call sequence can be changed from the *AADL* tab of the *Properties* view, and using the *Call Order* section options.

## Extending

## Selecting a Diagram Element's Container
To select a diagram element's container, right click on the child element and select *Select Container* from the context menu.

## Selecting All Connections
All connections can be selected by selecting *Edit->Select All Connections*.

# Instantiating{#sec:instantiating}
Component implementations can be instantiated by right-clicking the implementation on the diagram or *Outline* view and selecting *Instantiate* from the context menu. The instance model will be created in that projects *instances* folder in the AADL Navigator.

# Copying and Pasting
Portions of a diagram can by copied and pasted using the menu items described in @tbl:copy_and_paste_menu_items.

|Menu Item                | Description                              |
|------------------|------------------------------------------|
| *Copy*                  | Copies the selected diagram elements along with the associated model elements. |
| *Copy Diagram Elements* | Copies the diagram elements without copying the associated model elements. Pasting will create a diagram element for each copied diagram element for which the selected diagram element has a matching child model element. Useful for copying diagram element layout to another diagram.|
| *Paste*                 | Pastes the previously copied content into the selected diagram element. |
 
Table: Copy and Paste Menu Items {#tbl:copy_and_paste_menu_items}

# Diagram Configuration
Configuring a diagram allows customizing the contents of the diagram (See @sec:hidden_children). To configure a diagram, right-click in the diagram or an element in the *Outline* view and select *Configure Diagram…*. The diagram configuration dialog allows enabling specific diagram elements. A diagram element may be enabled manually or by configuring the content filters for the containing element.

The diagram configuration dialog also allows selecting which AADL properties will be included in the diagram. The communication_properties::timing property is implicitly enabled and is represented by specialized graphical indicators. Delayed connections have a double bar indicator in the middle. Immediate connections have a double arrow in the middle.

Connections which are manually enabled will be removed if the connection ends are not also included in the diagram. Connections that have one connection end visible on the diagram are represented as abstracted connections. (See @sec:abstracted_connections) 

The Hide Connection Labels option can be used to set the default visibility of labels for connections between diagram elements. Label visibility for individual elements can be controlled using the properties view described in section 3.1.16.

## Diagram Types
When creating a diagram, a type must be specified. A diagram's type determines the default filters used by the contents of the diagram. It also determines which AADL properties are enabled by default. All diagram types are equally customizable. A diagram element's filters determines the child elements that are shown on the diagram.

+-------------------+----------------------------------------------------------+-------------------------------------------------------------------------+--------------------------------------------------+
| Diagram Type      | Availability                                             | Default Filters                                                         | Properties                                       |
+===================+==========================================================+=========================================================================+==================================================+
| Custom            | Packages, Classifiers, System Instances, and Contextless | None                                                                    | None                                             |
+-------------------+----------------------------------------------------------+-------------------------------------------------------------------------+--------------------------------------------------+
| Package           | Packages, Contextless                                    | - Packages:  Classifiers                                                | None                                             |
|                   |                                                          | - Classifiers: Generalizations                                          |                                                  |
+-------------------+----------------------------------------------------------+-------------------------------------------------------------------------+--------------------------------------------------+
| Structure         | Classifiers and System Instances                         |- Classifiers: Features, Connections, Flow Specifications, Subcomponents | None                                             |
|                   |                                                          |- Subcomponents: Features, Connections, and Flow Specifications          |                                                  |
+-------------------+----------------------------------------------------------+-------------------------------------------------------------------------+--------------------------------------------------+
| Mode              | Component Classifiers                                    | - Classifiers: Modes and Mode Transitions                               | None                                             |
+-------------------+----------------------------------------------------------+-------------------------------------------------------------------------+--------------------------------------------------+
| Processor Binding | Component Implementation and System Instances            | - Classifiers: Systems, Processors, Virtual Processors,                 | Deployment_Properties::Actual_Processor_Binding  |
|                   |                                                          | - Devices, Threads, Thread Groups, and Processes                        |                                                  |
+-------------------+----------------------------------------------------------+-------------------------------------------------------------------------+--------------------------------------------------+

Table: Diagram Types {#tbl:diagram_types}

# Visualization
The following sections describe the diagram visual capabilities of the graphical editor.

## Inherited Elements{#sec:inherited_elements}
Elements which are inherited from another model element have a gray color. This indicates that any changes made to the 
model element will result in a change to model element other than the one in which it is contained in graphically.

## Customizing an Element's Appearance{#sec:de_apperance}
The appearance of diagram elements can be edited by using the *Appearance* tab of the *Properties* view (See @sec:properties_view).
	- The *Label Visibility* option allows hiding or showing the diagram element's label.
	- Font size can be edited by selecting the font size drop-down menu.
	- Line width can be edited by selecting the line width drop-down menu.
	- Elements can be displayed as an image by selecting the set image button, selecting *Select…*, and then selecting the desired image. Only images contained in referenced projects may be selected. To reference other projects, edit the project's properties. Whether an element is displayed as an image or using standard notation can be toggled by selecting the *Show as Image* check box.  The editor supports the following image file types: bmp, png, jpg, gif.
	- Outline color can be edited by clicking the outline button and selecting the desired color.
	- Font color can be edited by clicking the font color button and selecting the desired color.
	- Background color can be edited by clicking the background color button and selecting the desired color.

## Hidden Children{#sec:hidden_children}
Diagram elements which have children that are hidden have an asterisk appended to their labels.

## Abstracted Connections{#sec:abstracted_connections}
In some cases a connection between diagram elements will be represented by a dotted connection. This indicates that the connection is an abstraction of one or more AADL model elements. A tooltip will provide additional information about the abstracted model elements. Cases in which this occurs are listed below.

- An AADL connection between subcomponents where one or more of the referenced features are hidden.
- A flow specification which references a hidden feature which is contained in a feature group.
- An AADL property reference value for which the model element to which the property value applies is hidden.
- An AADL property reference value for which the referenced model element is hidden.

## Highlighting Flow Implementations and End-to-End Flow Specifications
Selecting a flow implementation or end-to-end flow specification from the flow drop-down in the toolbar will highlight the flow.  Flow Implementations and End To End Flows that have segments that are not shown in the diagram will be marked with an asterisk(*) in the drop-down.

## Moving Shapes Using Arrow Keys
1. Select the element to be moved.

2. Press the **.** key.

3. Using the *Arrow* keys, move the element to desired location.

4. Press the *Enter* key.

## Restore Missing Diagram Elements{#sec:restore_missing_diagram_elements}
If a a model element is renamed from the AADL text editor without using the *Rename Element* menu option, the diagram element may disappear from diagrams in which it appears. In such cases it is possible to restore the diagram elements using the following steps. Note: if the diagram is saved after the diagram elements disappears, it will not be possible to restore the missing diagram elements.

1. Select *Edit->Restore Missing Diagram Elements*. A window containing diagram elements which have been removed from the diagram because the associated model element is missing will appear.
2. Update the desired model references in the *New Reference* column.
3. Select OK. The diagram elements will be restored.

# Navigating Between Diagrams
The graphical editor supports several methods for navigating between diagrams.

## Creating a New Diagram
Diagrams may be associated with an existing model element such as an AADL package or classifier. Diagrams which are not associated with a specific model element may also be created. Such diagrams are referred to as contextless diagrams and may contain multiple AADL packages. An AADL model element may have multiple diagrams associated it.

## Opening Diagrams
Diagrams can be opened by right clicking on the AADL diagram in the *AADL Navigator* view and selecting *Open* from the context menu.

### AADL Element Related Diagrams
Diagrams that are related to an element can be opened by right clicking the desired element from the *Outline* view and using the *Open* sub-menu of the context menu.

### AADL Instance Model Diagrams
Instance model diagrams (See @sec:instantiating) can be opened by right clicking on the AADL instance model in the *AADL Navigator* view and selecting *Open Diagram* from the context menu. The instance model may not be modified using the graphical editor.

## Diagrams View
The *AADL Diagrams* view shows the diagrams contained in the workspace. To open the *AADL Diagrams* view:

1. Select *Windows->Show View->Other…* from the top-level menu. The *Show View* window will appear.
2. Select *AADL/AADL Diagrams*.
3. Select *Open*. The *AADL Diagrams* view will be opened.

By default, the *AADL Diagrams* view will group diagrams by the diagram type and the diagram's context. Grouping can be customized using the *Group By Type* and *Group by Context* options in the view menu (![View Menu](../images/ui_view_menu_icon.png)) for the *AADL Diagrams* view. Selecting *Show Decorations* from the view menu will toggle display of the context and type for diagrams which are not grouped.

## Diagram Context Adjustment
Diagrams are associated with model elements. Moving a model element between packages or renaming it or any of its containers from the AADL text editor without using the *Rename Element* menu option will break its association with diagrams. 

When opening a diagram, the *Missing Diagram Context* dialog will appear if the graphical editor is unable to find the model element associated with a diagram for any reason. If the element has been previously renamed, select the new name for the element and select *OK*.

# Diagram Layout
The following sections describe the diagram layout capabilities of the graphical editor.

## Layout Commands

Layout menu items are available from the *Edit->Layout* menu or by right clicking on the diagram or diagram element and using the *Layout* sub-menu. The behavior of the layout menu items are described in @tbl:layout_menu_items.

![](../images/layout_menu.png)


|Menu Option | Description|
|--------------------|--------------------------------------------------|
| *Layout Diagram* | Repositions and resizes the contents of the entire diagram. |
| *Layout Contents* | Repositions and resizes the contents of the selected element(s). |
| *Align Left* | Aligns the left of all selected elements with that of the primary selection. |
| *Align Center* | Aligns the horizontal center of all selected elements with that of the primary selection. |
| *Align Right* | Aligns the right of all selected elements with that of the primary selection. |
| *Align Top* | Aligns the top of all selected elements with that of the primary selection. |
| *Align Middle* | Aligns the vertical center of all selected elements with that of the primary selection. |
| *Align Bottom* | Aligns the bottom of all selected elements with that of the primary selection. |
| *Distribute Shapes Horizontally* | Moves the selected elements to produce equal horizontal spacing. |
| *Distribute Shapes Vertically* | Moves the selected elements to produce equal vertical spacing. |
| *Arrange in Grid* | Arranges the selected elements into a grid. |
| *Arrange in Circle* | Arranges the selected elements into a circle. |
| *Match Width* | Adjusts the width of all selected elements to match that of the primary selection. |
| *Match Height* | Adjusts the height of all selected elements to match that of the primary selection. |
| *Match Size* | Adjusts the width and height of all selected elements to match that of the primary selection. |
| *Remove Bendpoints* | Removes all bendpoints from the selected connections. | 

Table: Layout Menu Items {#tbl:layout_menu_items}

## Layout Preferences
The preferences dialog contains preferences which affect the layout behavior of the graphical editor. To edit layout preferences:

1. Select *Window->Preferences*

2. Select *OSATE->AADL Diagram Editor*

3. Modify the preferences as desired.

![](../images/Preferences.png)

## Incremental Layout
When an element has been added to the diagram and needs to be positioned or sized, an incremental layout is performed. The behavior of the incremental layout can be configured by selecting a mode from the preferences dialog. From the preferences dialog select the desired *Incremental Layout Mode*. The modes are described in @tbl:incremental_layout_modes.

|Mode| Description|
|-------|--------------------------------------------------|
| *Diagram* | Each time the editor needs to position or size an element, a layout will be performed on the entire diagram. User adjustments to the diagram layout will be replaced. This reduces the amount of user control over the layout.|
| *Container* | When an element is found that has neither a size or position, a layout is performed on the diagram element's container. Any manual layout information in the diagram element's container will be replaced. If the shape is created and positioned using the palette, the layout will only be performed on the contents of the new element. If a connection is created using the palette, the layout will be performed on the connection's container. |
| *Contents* | This is the default setting. A layout is performed on the contents of any element which does not have a size or position. This option is the least disruptive to the existing layout. However, new elements may overlap with existing elements. The *Layout Contents* menu item can be used to manually layout the contents of a container as needed. If a feature is added, it will be positioned after other features on the appropriate edge. If none of the siblings of an element have a position or size, then the layout will be performed on the container instead. This is done to provide a better layout in cases when an element does not have a user specified layout. |

Table: Incremental Layout Modes {#tbl:incremental_layout_modes}

## Layout Feature Based on Direction
When the *Layout Features Based on Direction* preference is enabled, the graphical editor will position ports based on the feature's direction. Input features will be placed on the left side and output features will be placed on the right side. If the preference is disabled, the layout algorithm will decide the side on which to place the feature.

## Known Layout Issues and Limitations
* Connections between multiple levels of the diagram hierarchy are not automatically routed and must be routed manually. Such connections usually represent property values such as bindings.
* Mode transition triggers are not routed. The recommended workaround is to show the mode transition triggers as text labels.
* Flow source and sinks are not consider when laying out the diagram.
* The automatic layout for flow path may produce unexpected routing and label placement for the flow path. To workaround this issue, it is recommended to disable labels for flow paths.	
* Flow paths other than those which include a feature on the left side and a feature on the right side of the container will not layout correctly. To workaround this issue, it is recommended to adjust the location of the features.

# Binding Creation
When viewing a component implementation diagram, a binding property associations can be created using the toolbar.
![](../images/BindToolbar.png)

# Annotations and Documentation
The following sections describe the graphical editors support for annotations and AADL documentation.

## Annotations
Diagrams can be annotated using the tools available in the *Annotation* section of the palette. The *Note* option allows adding text notes to the diagram. Notes are part of the diagram and are not part of the AADL model. The *Note Reference* option can be used to associate a note with another element in the diagram.

## AADL Documentation
AADL comments which begin with an extra hyphen are displayed by the diagram editor. They are displayed in the tooltips for the corresponding diagram element. Such comments are also displayed in the *Documentation* section of the *Properties* view. They cannot be modified using the graphical editor.

# Troubleshooting
The following section contains solutions to known issues as well as instructions for reporting problems with the graphical editor.

## Undo/Redo is Unavailable After Opening or Closing AADL Source Files
After opening or closing AADL source files, the undo and redo commands in the graphical editor are disabled. To workaround, either open the AADL source files before making changes or undo or redo operations as necessary before opening AADL source files.

## Build Automatically
*Project->Build Automatically* must be enabled.  If it is not enabled, the graphical editor will not function properly.

![](../images/BuildAutomatically.png)

## Inconsistent Font Sizes Across Machines
To ensure diagrams have a consistent appearance across machines, the graphical editor attempts to produce consistent text sizes regardless of system settings. However, due to limitations in the underlying libraries on which the graphical editor relies, this is not always possible. On windows systems, the graphical editor produces consistent font sizes at 100%, 125%, and 200% system text scaling levels.

## Missing Diagram Elements After Modification of AADL Source
See @sec:restore_missing_diagram_elements.

## Reporting Issues
Issues should be reported using the [OSATE Issue Tracker](https://github.com/osate/osate2/issues){target="_blank"}.

# Notices
Development of portions of the OSATE Graphical Editor was sponsored by the Government of the United States under Contract Number FA8702-15-D-0002.

The view, opinions, and/or filings contained in this material are those of the author(s) and should not be construed as an official position, policy, or decision of the Government of the United States or Carnegie Mellon University or the Software Engineering Institute, unless designated by other documentation.
