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
#Resource Budget Analyses#
The intent of the resource budget analysis is to provide resource budgeting support early in the development life cycle. Users may have defined a system model that essentially is a high level parts list, i.e., defines the execution platform in terms of a collection of processors, memory, buses. 

The application system in terms of major subsystems that may or may not be executed as separate partitions. The components may not yet have features, nor do their implementations have connections.  The application components may not have been elaborated beyond the first level of application subsystems, which may be represented as AADL **system**, **abstract**, or **process** component.

The SEI has provided a plug-in that supports resource budgeting and resource allocation analysis for computing resources, i.e., processors, memory, and buses (networks).
* Processor: a processor has a capacity in terms of MIPS. This is specified with the predeclared standard property **Processor_Capacity** (or the property **SEI::MIPSCapacity**). It takes real values with units of *KIPS, MIPS, GIPS*.  Application components specify their processor resource demand through the property **SEI::MIPSBudget**.  Systems, processes, thread groups, threads, and abstract components can have a MIPS budget.
> Note: A virtual processor is both a MIPS provider and a MIPS consumer. We use the **SEI::MIPSBudget** property to indicate the MIPS demand it has on the processor it is allocated to and the MIPS capacity it makes available to application components bound to it.

* Memory: we recognize both RAM and ROM as memory.  We have introduced the properties **SEI::RAMCapacity**, **SEI::ROMCapacity**, **SEI::RAMBudget**, and **SEI::ROMBudget** for that purpose.  These properties take real values using *Size_Units* as unit (*B, KB, MB, GB*). The capacity is associated with memory components.  Typically, a memory component will have either RAM capacity or ROM capacity.  RAM and ROM budgets can be associated with application components such as system, process, thread group, thread. We also look for **Memory_Size** as available capacity of a memory and **Data_Size**, **Code_Size**, **Heap_Size**, **Stack_Size** as actual demand for memory.

##Analyze MIPS and Memory Budgets Against Capacities##
The first resource budget analysis does not assume allocation of resources. It simply adds up the MIPS, RAM, and ROM capacities and budgets throughout a system instance and compares the totals.

The **Resource Budget Analysis** is invoked on an instance model through a toolbar command, or through the *Analysis* menu and the *Architecture* submenu, or through the green spreadsheet icon in the toolbar.

The analysis adds up the memory capacity expressed in terms of **Memory_Size**, **SEI::RAMCapacity**, **SEI::ROMCapacity**. A memory component may have only the **Memory_Size**, only **SEI::RAMCapacity** and/or **SEI::ROMCapacity**, or all three.   The following classifier types may be associated with the memory capacity properties: `memory`, `system`, `processor`, `virtual processor`, and `abstract`.  
The analysis also adds up the memory budgets expressed as **SEI::RAMBudget**, **SEI::ROMBudget**, and actual memory demand expressed by **Data_Size**, **Code_Size**, **Heap_Size**, and **Stack_Size**.

The results are reported in the *reports/ResourceBudgets* folder. 

The analysis keeps track of how many components that are expected to have capacity or budget property values and how many actually have the appropriate property value assigned.

As the application architecture of a system is refined we may have components with resource budgets that contain subcomponents with resource budgets. In this case the resource budget analysis tool will add up the budgets of the subcomponents and compare them to the budget of the enclosing component. It will use this number as the resource demand of the enclosing component to total up the demand. It will also compare this number against the specified budget of the enclosing component and report any difference (under- and over-allocation of the budget to subcomponents).

##Analyze Allocated Resources Budgets##
This analysis interprets allocation of software components to processors and to memory to compare the budgets of allocated components to the capacity of the resource they are allocated to. The allocations are specified through the **Actual_Processor_Binding** and **Actual_Memory_Binding** properties. In addition, this analysis takes into account any specification of actual resource usage such as execution time of threads, or actual memory requirements of application source code into account if they have been specified via properties.

Both the processor allocation and memory allocation analysis are invoked through the **Analyze Resource Allocation** command, available through the toolbar or through the *Analysis* menu and the *Architecture* submenu. The results are reported in the *reports/BoundResourceBudgets* folder and as Eclipse Problem Markers that can be examined through the *Problems* view.

> Note: If the system has operational modes, then the analysis is executed for each operational mode.

###Processor Allocation Analysis###
For each *processor* and *virtual processor* instance the analysis identifies the components that are bound to it. 
For each of these bound components the analysis examines the budget specification (**SEI::MIPSBudget**). In addition, if specified as properties of threads, the period (**Period**) and execution time (**Compute_Execution_Time**) are converted into MIPS and compared to the budget.  
> Note: For conversion to MIPS execution time is multiplied by the number of times a thread can execute per second (1 sec / period in sec). This time is then converted into MIPS by multiplying it with the *Processor_Capacity* or *SEI::MIPSCapacity* of the processor the thread is bound to. If more than one processor type with different MIPS capacity exists, then the thread may have a **Reference_Proessor** property to indicate the processor used to specify the execution time. In this case the time is adjusted to the allocated processor according to the MIPS ratio between the reference and the allocated processor.

The actual values, or the budget if the actual does not exist, are totaled up and compared against the capacity of the processor to which the components are bound.

This allows the user to make allocation decisions by reflecting them in the actual processor binding property. Early in the development those decisions are validated in terms of MIPS budget specifications. Later in the development, when timing information about components is available it can be added into the model. This may be done for the whole model or for some of the application components. The actuals are compared against the budgets and are used in the totaling of the resource demand on a processor.

> Note: The application system may have been defined as a nested set of components, each with a budget. As mentioned above the processor binding is inherited, i.e., both the parent and its children may have a processor binding value. In that case only the actual or budget MIPS of the children are totaled in order to avoid double counting of bound application component budgets.

###Memory Allocation Analysis###
For each of the memory components with a RAM or ROM capacity or **Memory_Size**, we sum up actual memory demand expressed by **Data_Size**, **Code_Size**, **Heap_Size**, and **Stack_Size**, or the RAM and ROM budgets for all component bound to the memory and compare the result with the memory size, and RAM/ROM capacity. For comparison against RAM or ROM capacity we assume code resides in ROM and the others in RAM. 

> In addition the **SEI::RAMActual** and SEI::**ROMActual** properties are added up and compared to the budgets. These two properties have been provided such that users can reflect actual memory usage of individual components, e.g., as reported by a compiler for threads, data components, and ports within threads.
> In case of nested application components with RAMActual or ROMActual property values, the actual value accounts for memory demands of that component only. In other words, contrary to the memory budget figures, the actual value does not represent a cumulative memory demand.
