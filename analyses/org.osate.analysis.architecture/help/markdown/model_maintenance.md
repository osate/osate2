<!--
Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
All Rights Reserved.

NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.

This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
which is available at https://www.eclipse.org/legal/epl-2.0/
SPDX-License-Identifier: EPL-2.0

Created, in part, with funding and support from the United States Government. (see Acknowledgments file).

This program includes and/or can make use of certain third party source code, object code, documentation and other
files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
conditions contained in any such Third Party Software or separate license file distributed with such Third Party
Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
-->
# Model Maintenance

The `Analysis > Model Maintenance` submenu in the main menubar contains analyses for simplifying, understanding, or otherwise "cleaning up" AADL models.  

## Find Unused Classifiers

The **Find Unused Classifiers** analysis scans one or more AADL package and marks each classifier (component type, component implementation, or feature group) that is not referenced from within the current Eclipse workspace.  

### Executing the Analysis

The analysis is found under the `Analysis > Model Maintenance` submenu in the main menubar, and in the context menu of the `AADL Navigator` view.  The analysis command is only available if 1 or more AADL package files are selected in the navigator.

![Find Unused Classifiers in the main menu](images/find-unused-main-menu.png)
![Find Unused Classifiers in the context menu](images/find-unused-context-menu.png)

When executed the analysis will search the Eclipse workspace for references to all the classifiers declared in the selected AADL packages.  

### Analysis Results

The analysis generates an Eclipse warning marker for each classifier that is not referenced in the workspace.  As is standard for Eclipse, these are visible in the `Problems` view.  The below shows the results of analysing two packages `MyPackage1` and `MyPackage2`:

![Problems view showing unused classifier markers](images/unused-markers.png)

Again, as is standard Eclipse practice, double-clicking on a marker in the view opens an Eclipse editor and highlights the entire classifier.

**Important:** Please note that a top-level system description will be marked as unused.  This is normal, and you must use your descretion to determine which classifiers represent instantiatable systems.


### Quick Fix

The markers support a "quick fix" that removes the unused classifier from the package.  Select 1 or more marker in the `Problems` view, and choose `Quick Fix` from the context menu.

![Quick Fix in the context menu](images/quick-fix-menu.png)

A confirmation dialog appears indicating that you are going to be removing the classifier:

![Quick fix dialog](images/quick-fix-dialog.png)

Click on `Finish` to remove the classifiers from the AADL package files.  

**Important:** _This operation is cannot be undone!_



