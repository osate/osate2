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
# Included Property Sets and Packages

[TOC levels=2-4 bullet hierarchy]

## Viewing Included AADL Files

All of the property sets and packages which are included by default in OSATE can be shown in the AADL Navigator. If you
expand an AADL project in the Navigator, you will see an item called `Plugin Contributions`. Expand this item and you
will see all of the property sets and packages contributed by the various plugins in OSATE. An included file can be
opened by double clicking on it.

![Plugin Contributions](images/PluginContributions.png)

## List of Property Sets and Packages Included in Core OSATE

The following are all of the property sets and packages included in a basic OSATE installation. Other property sets and
packages may be available in your installation if you have installed other plugins.

* `Predeclared_Property_Sets`: All of the property sets in this folder are specified by the AADL standard.
* `property set ARINC429`: Supplied for the **Check A429 Connection Consistency** analysis.
* `property set ARINC653`: Specified by the ARINC 653 annex to the AADL standard.
* `property set ARP4761`: Specified by the Error Model Language annex to the AADL standard.
* `package Base_Types`: Specified by the Data Modeling annex to the AADL standard.
* `property set Behavior_Properties`: Specified by the Behavior Model annex to the AADL standard.
* `property set Cheddar_Properties`: Supplied by the Ocarina plugin.
* `property set Code_Generation_Properties`: Specified by the Programming Language annex to the AADL standard.
* `property set Data_Model`: Specified by the Data Modeling annex to the AADL standard.
* `property set Deployment`: Supplied by the Ocarina plugin.
* `property set EMV2`: Specified by the Error Model Language annex to the AADL standard.
* `package ErrorLibrary`: Specified by the Error Model Language annex to the AADL standard.
* `property set MILSTD882`: Specified by the Error Model Language annex to the AADL standard.
* `property set Physical`: Supplied by the ALISA plugin.
* `package PhysicalResources`: Supplied by the ALISA plugin.
* `property set POK`: Supplied for the **Check Codegen Prerequisites For POK**, **Check Codegen Prerequisites For DeOS**, and **Check Codegen Prerequisites For VxWorks** analyses.
* `property set SEI`: Supplied for various analyses included in OSATE.