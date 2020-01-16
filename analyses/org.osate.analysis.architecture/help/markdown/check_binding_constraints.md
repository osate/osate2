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
# Check Binding Constraints
The objective of this plug-in is to check that a model conforms to various constraints specified in binding properties.

# Invoking the Analysis
 * Select an instance model in the **AADL Navigator**
 * In the main menu, select **Analyses** -> **Semantic Checks** -> **Check binding constraints**

![Main Menu Action](images/MainMenuAction.png)

# Results
Any problems that the analysis finds are reported in the **Problems** view:

![Results](images/AnalysisResults.png)

# List of Checks

## Processor binding is allowed
For each **thread**, **virtual processor**, and **device**, checks that the processor binding specified by
*Deployment_Properties::Actual_Processor_Binding* is allowed by *Deployment_Properties::Allowed_Processor_Binding* if
specified.

## Processor binding classifier is allowed
For each **thread**, **virtual processor**, and **device**, checks that the classifier of the processor binding
specified by *Deployment_Properties::Actual_Processor_Binding* is allowed by
*Deployment_Properties::Allowed_Processor_Binding_Class* if specified.

## Dispatch protocol is allowed
For each **thread**, **virtual processor**, and **device**, checks that the value of
*Thread_Properties::Dispatch_Protocol* is allowed by the processor binding. If the component has value for
*Deployment_Properties::Actual_Processor_Binding*, then the processor binding's
*Deployment_Properties::Allowed_Dispatch_Protocol* will be checked against the dispatch protocol of the component.

## Memory binding is allowed
For each **thread**, **device**, **data**, **subprogram**, **processor**, **virtual processor**, **data port**, and
**event data port**, checks that the memory binding specified by *Deployment_Properties::Actual_Memory_Binding* is
allowed by *Deployment_Properties::Allowed_Memory_Binding* if specified.

## Memory binding classifier is allowed
For each **thread**, **device**, **data**, **subprogram**, **processor**, **virtual processor**, **data port**, and
**event data port**, checks that the classifier of the memory binding specified by
*Deployment_Properties::Actual_Memory_Binding* is allowed by *Deployment_Properties::Allowed_Memory_Binding_Class* if
specified.

## Connection binding is allowed
For each **connection** and **virtual bus**, checks that the connection binding specified by
*Deployment_Properties::Actual_Connection_Binding* is allowed by *Deployment_Properties::Allowed_Connection_Binding* if
specified.

## Connection binding classifier is allowed
For each **connection** and **virtual bus**, checks that the classifier of the connection binding specified by
*Deployment_Properties::Actual_Connection_Binding* is allowed by
*Deployment_Properties::Allowed_Connection_Binding_Class* if specified.

## Required connection quality of service is provided
For each **connection** and **virtual bus**, checks that the QoS specified by
*Deployment_Properties::Required_Connection_Quality_Of_Service* is provided by the connection binding specified by
*Deployment_Properties::Actual_Connection_Binding*. A connection binding provides a QoS with the property
*Deployment_Properties::Provided_Connection_Quality_Of_Service*.

## Required virtual bus classifier is provided
For each **connection** and **virtual bus**, checks that the virtual bus classifier specified by
*Deployment_Properties::Required_Virtual_Bus_Class* is provided by the connection binding specified by
*Deployment_Properties::Actual_Connection_Binding*. A connection binding can provide a virtual bus classifier with the
property *Deployment_Properties::Provided_Virtual_Bus_Class*. If a connection binding directly contains virtual bus
subcomponents, then the classifiers of those subcomponents are also provided by the connection binding.