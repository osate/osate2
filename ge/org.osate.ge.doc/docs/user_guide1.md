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
1. Select *File->New->Other...->AADL Project*
2. Enter project name: MyFirstProject
3. Click *Finish*

## Create a New Package
make sure to add references to docs
1. Right-click your new project
2. Select *New->Other...->AADL->AADL Package*
3. Enter package name: MyFirstPackage
4. Select *Diagram Editor*
5. Click *Finish*
6. Click *OK*


# Creating Model Elements
Elements are created by selecting the desired element from the palette and placing it on the diagram.


## Creating Implementations
Selecting the desired implementation from the palette and placing on an eligible type.


# Editing Model Elements


## Property View
The properties sheet contains properties for the currently selected diagram elements. The properties sheet can be opened by 
double-clicking on a diagram element in the diagram or in the outline. Alternatively, the properties sheet can be opened by 
right-clicking on a diagram element in the diagram or outline and selecting *Properties...* from the context menu.


## Renaming
Elements can be renamed three ways:
<br>&nbsp; 1. Right clicking an element in the *Outline* view selecting *Rename...*.
<br>&nbsp; 2. Right clicking an element on the diagram and selecting *Rename...*.
<br>&nbsp; 3. Selecting an element on the diagram, then clicking and hovering over the label.


## Deleting
Elements can be deleted three ways:
<br>&nbsp; 1. Right clicking an element in the *Outline* view selecting *Delete*.
<br>&nbsp; 2. Right clicking an element on the diagram and selecting *Delete*.
<br>&nbsp; 3. Selecting an element on the diagram and pressing the *Delete* key.


## Indirect Editing
To allow for easier editing, the editor allows editing classifiers in the context of related model elements. For example, a data port may 
be created inside a component implementation. Since AADL component implementations cannot contain data ports, the data port will be 
created inside the component implementation's type (See @sec:inherited_elements). In cases where there are multiple potential classifiers to edit, the editor will 
prompt to select a classifier.

# Copying and Pasting
Portions of a diagram can by copied and pasted using the menu items described in @tbl:copy_and_paste_menu_items.

|Menu Item                | Description                              |
|------------------|------------------------------------------|
| *Copy*                  | Copies the selected diagram elements along with the associated model elements. |
| *Copy Diagram Elements* | Copies the diagram elements without copying the associated model elements. Pasting will create a diagram element for each copied diagram element for which the selected diagram element has a matching child model element. Useful for copying diagram element layout to another diagram.|
| *Paste*                 | Pastes the previously copied content into the selected diagram element. |
 
Table: Copy and Paste Menu Items {#tbl:copy_and_paste_menu_items}


# Diagram Configuration
Configuring a diagram allows customizing the contents of the diagram. To configure a diagram, right-click in the diagram and select Configure Diagram…. The diagram configuration dialog allows enabling specific diagram elements. A diagram element may be enabled manually or by configuring the content filters for the containing element.

The diagram configuration dialog also allows selecting which AADL properties will be included in the diagram. The communication_properties::timing property is implicitly enabled and is represented by specialized graphical indicators. Delayed connections have a double bar indicator in the middle. Immediate connections have a double arrow in the middle.

Connections which are manually enabled will be removed if the connection ends are not also included in the diagram.

The Hide Connection Labels option can be used to set the default visibility of labels for connections between diagram elements. Label visibility for individual elements can be controlled using the properties view described in section 3.1.16.

# Visualization
## Inherited Elements{#sec:inherited_elements}
Elements which are inherited from another model element have a gray color. This indicates that any changes made to the 
model element will result in a change to model element other than the one in which it is contained in graphically.


## Customizing an Element's Appearance{#sec:de_apperance}
The appearance of diagram elements can be edited by using the *Appearance* tab of the *Properties* view.

An element's appearance can be changed using the following steps.

1. Open the *Properties* view by double-clicking on an element or by selecting *Properties...* from the context menu.

2. Select the diagram element(s) to be edited.

3. Select the *Appearance* tab.

4. Select desired appearance options.
	- The *Label Visibility* option allows hiding or showing the diagram element's label.
	- Font size can be edited by selecting the font size drop-down menu.
	- Line width can be edited by selecting the line width drop-down menu.
	- Elements can be displayed as an image by selecting the set image button, selecting *Select...*, and then selecting the desired image. Only images contained in referenced projects may be selected. To reference other projects, edit the project's properties. Whether an element is displayed as an image or using standard notation can be toggled by selecting the *Show as Image* check box.  The editor supports the following image file types: bmp, png, jpg, gif.
	- Outline color can be edited by clicking the outline button and selecting the desired color.
	- Font color can be edited by clicking the font color button and selecting the desired color.
	- Background color can be edited by clicking the background color button and selecting the desired color.



# Navigating Between Diagrams
The graphical editor supports several methods for navigating between diagrams.

## Diagrams View
The *AADL Diagrams* view shows the diagrams contained in the workspace. To open the *AADL Diagrams* view:

1. Select *Windows->Show View->Other...* from the top-level menu. The *Show View* window will appear.
2. Select *AADL/AADL Diagrams*.
3. Select *Open*. The *AADL Diagrams* view will be opened.

By default, the *AADL Diagrams* view will group diagrams by the diagram type and the diagram's context. Grouping can be customized using the *Group By Type* and *Group by Context* options in the view menu (![View Menu](../images/ui_view_menu_icon.png)) for the *AADL Diagrams* view. Selecting *Show Decorations* from the view menu will toggle display of the context and type for diagrams which are not grouped.

## Menu Items

## Outline

## Layout Diagrams

## Flow Editing

## Binding Creation??? maybe move somewhere

## Annotations and Documentation

## Troubleshooting
