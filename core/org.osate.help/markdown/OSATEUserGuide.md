# OSATE User Guide

OSATE is a complete modeling environment providing support for describing AADL models. It is composed of many features to model and analyse systems.  Also, a user can build their own tools based on OSATE and extend its initial capability.

This manual provides an overview of the basic features of OSATE and describes how to work with AADL models:

* Eclipse Basics
* Creating an AADL Project
* Writing Your First AADL Model
* Navigating the AADL Text Editor
* Instantiating Your Model
* Viewing AADL Prop

This manual also includes as reference material

* AADL Syntax Rules
* Suggested AADL Style Guide



## Eclipse Basics

OSATE is built on the Eclipse framework.  You may be familiar with Eclipse from using it for Java development.  OSATE inherits many concepts from Eclipse including

* **The Workbench.**  The main UI.
* **Projects.**   Work is divided into projects that group together related files.  Projects may be closed when they are not in use to prevent then from taking up OSATE reousrces and to prevent accidental modification.
* **Views.**  A view is a read-only display of information.  A view may be connected to a specific object in the OSATE workspace (often times the currenty selected object).
* **Editors.**  Not surprisingly, an editor provides write access to information in a project.  For example, OSATE has both a textual and graphical editor for AADL packages.
* **Perspectives.**  A perspective is a prearranged collection of views, editors, and toolbars focused around a particular task.  In OSATE you really only care about the `AADL` perspective.
* **Markers.**   A marker is a piece if information attached to a location in a file.  They are commonly used to report errors and warnings about files.  For example, OSATE uses markers to report syntax errors in AADL files.  Ananlysis plug-ins often use markers to communicate their results.  Markers are visible in several ways.  They are most commonly interacted with as annotations within editors and as a list in the `Problems` view.



### Eclipse Help

If you are unfamiliar with Eclipse, the "Workbench User Guide" in the Eclipse help system is an excellent introduction.  This can be accessed in OSATE by going to the `Help` menu in the main OSATE window and selecting `Help Contents`:

![Menu Bar](images/OSATEUserGuide/help1.png)

A new broweser window will open with a table of contents on the left-hand side.  The `Workbench User Guide` is he first document in the list:

![Help Window](images/OSATEUserGuide/help2.png)



### The Workbench

All work in the OSATE is done through a _Workbench_.  This is the main window, and it generally fills most or all your screen.  The look and contents of the workbench are highly customizable, but it is uncommon to deviate too much from its default layout.  Generally it has 

* A row of toolbars along the top.
* A "navigator" view along the left-hand side.  This view displays all the available projects and their contents.  OSATE uses a customized `AADL Navigator` that also displays globally available AADL property sets provided by plug-ins.
* An "outline" view on the right-hand side.  This view interacts with the active editor window and displays a structured semantic or syntactic outline of the contents of the editor.  It can be used to quickly navigate the contents of the editor.
* The `Problems` view along the bottom.  This view is used to interact with markers.

The rest of the center space of the workbench is used to hold editor windows.  This layout can be seen in the workbench window below that is set to the OSATE `AADL` perspective:

![Workbench](images/OSATEUserGuide/workbench.png)

There are several other features of the workbench visible in the above image:

* Views can have their own toolbars.
* Views can be stacked into "tabbed" layouts.  Tihs is visible along the bottom of the workbench where there are tabs for the `Problems`, `Properties`, and `AADL Property Values` views.
* Views can have their own menus.  The menu is accessible by clicking on the downward facing triangle in the top right of the view's toolbar: ![](images/OSATEUserGuide/ViewMenu.png).
* Views can be minimized or maximized within the workbench window using the toolbar buttons ![](images/OSATEUserGuide/MinMax.png).
* Views can be closed by clicking on the "x" icon on their tab.



#### Commands

As an Eclipse-based application, OSATE makes its commands available in multiple modalities.  A single command is usually available

* In an OSATE menu
* In a toolbar
* In a context menu, when appropriate to the currently selected object.  (A context menu is uaually opened with a right-click in Windows, ore a `CTRL` + click in MacOS.)



#### Missing Views

If you accidently close a view or simply want to add an additioanl view to the workbench, you can open a view by using the `Window > Show View` submenu in the main OSATE menubar:

![Show View Menu](images/OSATEUserGuide/ShowView.png)

This menu is populated with views specific to the current perspective.  Here we see the `AADL Navigator` and `AADL Property Values` views specific to the `AADL` perspective.  If you do not see the view you need listed, choose the `Other...` option to bring up the `Show View` Dialog:

![Show View Dialog](images/OSATEUserGuide/ShowViewDialog.png)

This dialog lists all the views avaible.  Views are grouped by category.  Above we see the `Error Log` view in the `General` category being selected for use.



#### Reseting the Perspective

If you open/close too many new views, rearrange your views, or otherwise put you workbench in a state that find unusable, you can bring it back to good state by resetting the perspective.  In the case of OSATE, you should reset the `AADL` perspective by bringing up the _context menu_ on the `AAADL` perspecitive icon on the right side of the workbench toolbar, and selecting `reset`:

![Reset Perspective](images/OSATEUserGuide/ResetPerspective.png)

This returns the arrangement of views and editors to a the default layout defined by the perspective.



### OSATE Preferences

OSATE (via its Eclipse underpinnings) has an exhaustive set of preferences that can be changed.  These are accessed via the `Preferences` window.  Access to preferences follows the host operating system standards:

* For windows, the preferences are under `Window > Preferences`.
* For MacOS, the prefernece are under `OSATE > Preferences...`.

This brings up a window with a hierarchical list of settings on the left-hand side.

One setting of immediate interest is found under `General > Startup and Shutdown`.  By default the setting `Refresh workspace on startup` is not enabled.  Enabling it ensures that when starting up, OSATE updates its records to reflect any changes to the files in the workspace that may have occurred outside OSATE.

![Preferences Window](images/OSATEUSerGuide/Preferences.png)



### Manual Refresh

You can manually initiate a refresh by selecting projects, folders, or files in the `AADL Navigator` and invoking `File > Refresh` in main menu or `Refresh` in the navigator's context menu.



## Creating an AADL Project

Let us create an AADL Project in OSATE.   