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
#Analyze Electrical Power Usage#

OSATE supports modeling and analysis of electrical power distribution and consumption. You can introduce an *abstract* component type to represent the concept of electrical power, e.g., call it *Electricity*. We will use it as the type of component features. 
Our electrical power analysis framework supports the concept of **power suppliers** and **power consumers**. A **power transmission system** is used to move electrical power from suppliers to consumers.
## Electrical Power Suppliers##
Any component type can be an electrical *power supplier*. However, it only make sense for physical components (**device**, **processor**, **bus**, **memory**) as well as **system**, and **abstract**.
We represent the fact that it supplies electricity by defining an outgoing feature, e.g., an abstract feature **out feature**. The fact that it supplies power is indicated by the property **SEI::PowerSupply**. You associate this property value with the outgoing feature. The values are real values in units of *mW* (milli watts), *W* (watts), *KW* (Kilo watts).
Users should also associate a component type as the type of the feature. This ensures that when connections are made that only features dealing with electricity are connected to each other.
## Electrical Power Consumers##
Any component type can be an electrical *power consumer*. We represent this by an incoming feature, e.g., **in feature**. In this case we use the property **SEI::PowerBudget** to indicate the demand for electrical power. Again the values are reals in units of watts.
## Electrical Power Transmission System##
We use **system**, **device**, or **abstract** components to represent the transmission system for electrical power. It has the property **SEI::PowerCapacity** in units or watts. It indicates the amount of electrical power it is able to handle. 
The component type also has abstract features to indicate connection points to suppliers and to consumers. Feature connections are used to make the actual connections.

##Electrical Power Analysis##
Electrical power analysis is available under the *Analyses/Architecture* menu as *Analyze power requirements*, or by clicking on the battery icon in the tool bar. The command is invoked on the selected instance model.

The analysis is performed for each component that represents a transmission system. The analysis identifies all suppliers and totals the supply. Similarly, it totals the budgets of all consumers. The analysis then ensures that neither the supply total, nor the budget total exceeds the capacity. It also ensure that the budget total does not exceed the supply total.
The results of the analysis are recorded in a report under the *reports/Power* folder. It shows for each transmission system the capacity, the list of suppliers and their amount, the list of consumers and their budgets, as well as their totals. The report closes with the comparison results.
The result comparisons are also recorded as Eclipse Markers and can be viewed in the Eclipse *Problems* view. 
> Note that in the problems view you can define filters to to sort the view by problem marker type, and to only see Markers of certain types.

##Electrial Power Transmission Subsystems##
Electrical power transmission systems can themselves be consumers of electrical power that they receive from another transmission system rather than directly from a supplier. For example, a transmission subsystem may draw its power from a transmission backbone. This is modeled by an *incoming* feature with a *power budget* property.

##Examples##
One example is available on [Github/Osate](https://github.com/osate/examples) and is called *ResourceBudgets*. You instantiate the top level system called *MySystem* as a tier0 model or as a tier2 model. It has a single transmission system.

A second example is available on [Github/Osate](https://github.com/osate/alisa-examples) and is called *MutliTierAircraftExample*. You will find a set of project under *MultiTierAircraft* with the AADL model. The example is from the System Architecture Virtual Integration (SAVI) initiative. It has a backbone transmission system as well as a subsystem within the IMA of the aircraft.
The project AircraftSpecified represents *Tier1*, i.e., a single layer. AircraftIntegrated represents variants of *Tier2*, which includes the Integrated Modular Avionics (IMA) at one level of detail.
> Note: The example also includes a requirement and verification plan specification for automated incremental life cycle assurance under the ALISA plug-ins (see ALISA help for details).
