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
#MassAnalysis: Dealing with Weight in a System#

The analysis tool performs several types of *weight* related analysis. We understand the difference between *mass* and *weight*. Mass is not affected by gravity while weight is. Currently we use the word *weight* in the property names. Users can interpret them as mass or weight. 
##Weight Related Properties##

The Mass Analysis utilizes three properties. These properties are currently in the *SEI* property set.
* **WeightLimit**: represents the weight budget a component and its parts are expected to satisfy.
* **GrossWeight**: represents the total actual weight of a component and its parts.
* **NetWeight**: represents the weight of a component by itself without taking into account the weight of its parts.

##Consistency Rules Regarding the Weight Properties##

Here are some assumptions about the relationship between these three properties and their use in the model.
* *Gross and net weight invariant*: The gross weight of a component is expected to be the sum of its own net weight and the gross weights of its directly contained part, aka. the net weights of all its parts recursively.
* *Gross and/or net weight*: The analysis does not require the user to specify both the gross and net weight. 
* *Leaves in the component hierarchy*: For components without subcomponents the net and gross weight are expected to be the same. Since they can be used interchangably users only need to specify one and the tool will use either one. 
* *Who needs to have this property*: The analysis assumes the processes, thread groups, threads, virtual buses, and virtual buses do not have weights, thus, skip them. For the other components it is currently up to the user to supply the properties. The analysis will report components components without weight properties.
* *Is weight limit necessary*: Weight limit is only necessary for the top level system. In this case you will get an analysis that compares the actual weight all the system parts against the limit. If you put weight limits on parts as well you get the effect of compositional mass budgeting and analysis. For large scale systems the impact of changes in actual weight of a part will then be partially buffered by resource reserves at each system level with a weight limit as budget.

##Weight Consistency Checks and Analysis##

The mass analysis is invoked on an instance model. It performs three types of analysis and consistency checking:
* *Consistency between gross and net weights*:  For each layer in the system hierarchy the analysis will report inconsistencies between the assigned net and gross weights of components and their subcomponents.
* *Weight limits as budgets*: The analysis will compare the weight limits of the subcomponents against the weight limit of a component to ensure that the budget assigned to subcomponents do not exceed the available resource (mass) for the component. The analysis will identify and report reserves, i.e., when the subcomponent weight limit totals are below the component total. It also reports the the subcomponent total exceeds the limit.
* *Compare actuals against budgets*:  For each layer of the system hierarchy the analysis compares the actual against the budget, i.e., the sum of net or the respective gross weight against the weight limit. It will report any cases when the actual exceeds the weight limit. If there is a discrepancy between the net and gross weights - as discussed above - the analysis will use the larger number when propagating actual weights up the hierarchy.

##Weight Analysis Reports##

The analysis tool produces an analysis report as a e[csv] file. This file can then be examined in a text editor or in Excel. 

The analysis also generated a set of Eclipse Markers that can be viewed through the Eclipse *Problems*] view. 

Finally, we have interfaced the analysis with the *Alisa* workbench for incremental life cycle assurance. Currently the results are extracted by *Alisa* via the Eclipse Markers and mapped into the results record of an assurance case.

The report has messages with markings of three types, in addition to being tagged as *error*, *warning*, or *info*.
* **[A]** for reported items regarding the weight actuals.
* **[L]** for reported items regarding the weight limit.
* **[C]** for reported items regarding consistency between gross and net weights.

> ##Examples##
One example is available on [Github/Osate](https://github.com/osate/examples) and is called *ResourceBudgets*. You instantiate the top level system called *MySystem* as a tier0 model or as a tier2 model. It has a single transmission system.

A second example is available on [Github/Osate](https://github.com/osate/alisa-examples) and is called *MutliTierAircraftExample*. You will find a set of project under *MultiTierAircraft* with the AADL model. The example is from the System Architecture Virtual Integration (SAVI) initiative. It has a backbone transmission system as well as a subsystem within the IMA of the aircraft.

> Note: The example also includes a requirement and verification plan specification for automated incremental life cycle assurance under the ALISA plug-ins (see ALISA help for details).

