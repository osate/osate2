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
# Working Sets

[TOC levels=2-4 bullet hierarchy]

## Introduction

When working with a large set of projects, it can become difficult to keep track of and navigate all of these projects
in the AADL Navigator. Working sets allow you to group related projects in the Navigator. The following two images show
examples of the AADL Navigator with many projects. The first shows the list of projects without using working sets and
the second shows the same projects grouped by working set.

![Without Working Sets](images/workingSets/WithoutWorkingSets.png)

![With Working Sets](images/workingSets/WithWorkingSets.png)

## Creating a Working Set

To create a working set, start by opening the AADL Navigator's menu. This is accessed by clicking on the small downward
pointing triangle icon in the top-right of the navigator. From the menu, click **Select Working Set...**

![Navigator Menu](images/workingSets/NavigatorMenu.png)

In the dialog that opened, click on the **New...** button. For the type of working set, select **Resource**, then click
**Next >**.

![New Working Set Wizard](images/workingSets/NewWorkingSetWizard.png)

Specify the name of the new working set and check the projects that it should contain. Note that a project can be
contained in multiple working sets. Click **Finish** to create the working set. Once created, a working set can be
modified by clicking on the **Edit...** button in the **Select Working Set** dialog.

## Showing the Working Sets in the AADL Navigator

Once the working sets are created, the navigator can then be configured to display the working sets. To do this, first
configure the navigator to display working sets as the top level elements instead of projects. Open the AADL
Navigator's menu and click **Top Level Elements** -> **Working Sets**.

![Top Level Working Sets](images/workingSets/TopLevelWorkingSets.png)

Second, the working sets that should be displayed must be selected. Open the navigator's menu again and click
**Select Working Set...** Use this dialog to check which working sets should be shown as top level elements in the
navigator. Once you have made your selection, click **OK**.

![Select Working Set](images/workingSets/SelectWorkingSet.png)

It is also possible to show the contents of the selected working sets without showing the working set name itself. This
can be useful if you want to focus on one working set and ignore all others. To do this, open the navigator's menu and
click **Top Level Elements** -> **Projects**. Then open the **Select Working Set** dialog and select the working sets
you want to display. Here is an example of the navigator showing the projects of only one working set:

![One Working Set](images/workingSets/OneWorkingSet.png)

If you want to return the navigator to showing all projects, simply open the navigator's menu and click
**Deselect Working Set**.

## Exporting and Importing Working Sets

You can export and import working sets to share working set configurations among various workspaces. This can be useful
if you have a team of people that have the same projects in their workspaces. This can be used to share the same
working set definitions among every member of the team. To export your working sets, click on **File** -> **Export...**
in the main menu. Select **General** -> **Working Sets** and click **Next >**. Check the working sets you want to
export and select the file where this should be stored. Click **Finish** to export the working sets.

![Export Working Sets](images/workingSets/ExportWorkingSets.png)

To import working sets, click on **File** -> **Import...** in the main menu. Select **General** -> **Working Sets** and
click **Next >**. Select the file to import from and the working sets from that file to import. If
**Merge with existing working sets** is selected, then for any working set that already exists in the workspace, after
import, the working set will contain all projects that it previously contained and all projects from the import. If
**Merge with existing working sets** is not selected, then the import skips any working sets that already exist.

![Import Working Sets](images/workingSets/ImportWorkingSets.png)