#Resource Budget Analyses#
The intent of the resource budget analysis is to provide resource budgeting support early in the development life cycle. Users may have defined a system model that essentially is a high level parts list, i.e., defines the execution platform in terms of a collection of processors, memory, buses. 

The application system in terms of major subsystems that may or may not be executed as separate partitions. The components may not yet have features, nor do their implementations have connections.  The application components may not have been elaborated beyond the first level of application subsystems, which may be represented as AADL **system**, **abstract**, or **process** component.

The SEI has provided a plug-in that supports resource budgeting and resource allocation analysis for computing resources, i.e., processors, memory, and buses (networks).
* Processor: a processor has a capacity in terms of MIPS. This is specified with the predeclared standard property **Processor_Capacity** (or the property **SEI::MIPSCapacity**). It takes real values with units of *KIPS, MIPS, GIPS*.  Application components specify their processor resource demand through the property **SEI::MIPSBudget**.  Systems, processes, thread groups, threads, and abstract components can have a MIPS budget.
> Note: A virtual processor is both a MIPS provider and a MIPS consumer. We use the **SEI::MIPSBudget** property to indicate the MIPS demand it has on the processor it is allocated to and the MIPS capacity it makes available to application componments bound to it.

* Memory: we recognize both RAM and ROM as memory.  We have introduced the properties **SEI::RAMCapacity**, **SEI::ROMCapacity**, **SEI::RAMBudget**, and **SEI::ROMBudget** for that purpose.  These properties take real values using *Size_Units* as unit (*B, KB, MB, GB*). The capacity is associated with memory components.  Typically, a memory component will have either RAM capacity or ROM capacity.  RAM and ROM budgets can be associated with application components such as system, process, thread group, thread.

* Bus: we recognize bandWidth as a resource. Buses have **SEI::BandwidthCapacity** and connections have **SEI::BandwidthBudget**.

##Analyze MIPS and Memory Budgets Against Capacities##
The first resource budget analysis does not assume allocation of resources. It simply adds up the MIPS, RAM, and ROM capacities and budgets throughout a system instance and compares the totals.

The **Resource Budget Analysis** is invoked on an instance model through a toolbar command, or through the *Analysis* menu and the *Architecture* submenu, or through the green spreadsheet icon in the toolbar.

The results are reported in teh *reports/ResourceBudgets* folder. The analysis reports on how many components that are expected to have capacity or budget actually have the appropriate property value assigned.

As the application architecture of a system is refined we may have components with resource budgets that contain subcomponents with resource budgets. In this case the resource budget analysis tool will add up the budgets of the subcomponents and compare them to the budget of the enclosing component. It will use this number as the resource demand of the enclosing component to total up the demand. It will also compare this number against the specified budget of the enclosing component and report any difference (under- and over-allocation of the budget to subcomponents).

##Analyze Allocated Resources Budgets##
This analysis interprets allocation of software components to processors and to memory to compare the budgets of allocated components to the capacity of the resource they are allocated to. The allocations are specified through the **Actual_Processor_Binding** and **Actual_Memory_Binding** properties. In addition, this analysis takes into account any specification of actual resource usage such as execution time of threads, or actual memory requirements of application source code into account if they have been specified via properties.

Both the processor allocation and memory allocation analysis are invoked through the **Analyze Resource Allocation** command, available through the toolbar or through the *Analysis* menu and the *Architecture* submenu. The results are reported in the *reports/BoundResourceBudgets* folder and as Eclipse Problem Markers that can be examined through the *Problems* view.

> Note: If the system has operational modes, then the analysis is executed for each operational mode.

###Processor Allocation Analysis###
For each *processor* and *virtual processor* instance the analysis identifies the components that are bound to it. 
For each of these bound components the analysis examines the budget specification (**SEI::MIPSBudget**). In addition, if specified as properties of threads, the period (**Period**) and execution time (**Compute_Execution_Time**) are converted into MIPS and compared to the budget.  
> Note: For conversion to MIPS execution time is multiplied by the number of times a thread can execute per second (1 sec / period in sec). This time is then converted into MIPS by multiplying it with the *Processor_Capacity* or *SEI::MIPSCapacity* of the processor the thread is bound to. If more than one processor type with different MIPS capacity exists, then the thread may have a **Reference_Proessor** property to indicate the processor used to specify the execution time. In this case the time is adjusted to the allocated processor according to the MIPS ratio between the reference and the allocted processor.

The actual values, or the budget if the actual does not exist, are totaled up and compared against the capacity of the processor to which the components are bound.

This allows the user to make allocation decisions by reflecting them in the actual processor binding property. Early in the development those decisions are validated in terms of MIPS budget specifications. Later in the development, when timing information about components is available it can be added into the model. This may be done for the whole model or for some of the application components. The actuals are compared against the budgets and are used in the totaling of the resource demand on a processor.

> Note: The application system may have been defined as a nested set of components, each with a budget. As mentioned above the processor binding is inherited, i.e., both the parent and its children may have a processor binding value. In that case only the actual or budget MIPS of the children are totaled in order to avoid double counting of bound application component budgets.

###Memory Allocation Analysis###
For each of the memory components with a RAM or ROM capacity, we sum up the RAM and ROM budgetds for all component bound to the memory and compare the result with the capacity.

> In addition the **SEI::RAMActual** and SEI::**ROMActual** properties are added up and compared to the budgets. These two properties have been provided such that users can reflect actual memory usage of individual components, e.g., as reported by a compiler for threads, data components, and ports within threads.
> In case of nested application components with RAMActual or ROMActual property values, the actual value accounts for memory demands of that component only. In other words, contrary to the memory budget figures, the actual value does not represent a cumulative memory demand.

##Analyze Bound Bus Load##
This analysis takes each bu instance and compares its bandwidth cpacity against the demands placed on the bus by connections that are bound directly to the bus, or indirectly via virtual bus bindings. The binding is exspressed by the **Actual_Connection_Binding** property.

Both the processor allocation and memory allocation analysis are invoked through the **Analyze Bus Load** command, available through the toolbar or through the *Analysis* menu and the *Architecture* submenu. The results are reported in the *reports/Bandwidth* folder and as Eclipse Problem Markers that can be examined through the *Problems* view.

> Note: If the system has operational modes, then the analysis is executed for each operational mode.

The bandwidth demand is determined as follows:
* By computing the budget value of the connection using the **Data_Size** property of the data type of the source port and the  the **Period** property of the source thread or device. If not present
* By retrieving the budget value associated to this connection 	    specified with the **SEI::BandWidthBudget** property on the connection.

> Note: If the bus has a **Broadcast_Protocol** property value of **true**, then the transfer of data from the same source port to multiple destination ports is counted only once.

> Note: If a connection does not have an Actual_Connection_Binding property, the tool tries to infer a connection binding from the processor bindings of the connection source and destination by looking for a bus that connects the hardware components of the source and destination, i.e., the hardware component the software component is bound to, or the device that is connected.
> ##Examples##
One example is available on [Github/Osate](https://github.com/osate/examples) and is called *ResourceBudgets*. You instantiate the top level system called *MySystem* as a tier0 model or as a tier2 model. It has a single transmission system.

A second example is available on [Github/Osate](https://github.com/osate/alisa-examples) and is called *MutliTierAircraftExample*. You will find a set of project under *MultiTierAircraft* with the AADL model. The example is from the System Architecture Virtual Integration (SAVI) initiative. It has a backbone transmission system as well as a subsystem within the IMA of the ar> ##Examples##
One example is available on [Github/Osate](https://github.com/osate/examples) and is called *ResourceBudgets*. You instantiate the top level system called *MySystem* as a tier0 model or as a tier2 model. It has a single transmission system.

A second example is available on [Github/Osate](https://github.com/osate/alisa-examples) and is called *MutliTierAircraftExample*. You will find a set of project under *MultiTierAircraft* with the AADL model. The example is from the System Architecture Virtual Integration (SAVI) initiative. It has a backbone transmission system as well as a subsystem within the IMA of the aircraft.
The project AircraftSpecified represents *Tier1*, i.e., a single layer. AircraftIntegrated represents variants of *Tier2*, which includes the Integrated Modular Avionics (IMA) at one level of detail. For resource budget analysis we can instantiate the IMA, i.e., the **FlightGuidanceImplementation**. 
> Note: The example also includes a requirement and verificaiotn plan specification for automated incremental life cycle assurance under hte ALISA plug-ins (see ALISA help for details).
icraft.
The project AircraftSpecified represents *Tier1*, i.e., a single layer. AircraftIntegrated represents variants of *Tier2*, which includes the Integrated Modular Avionics (IMA) at one level of detail. For resource budget analysis we can instantiate the IMA, i.e., the **FlightGuidanceImplementation**. 
> Note: The example also includes a requirement and verificaiotn plan specification for automated incremental life cycle assurance under hte ALISA plug-ins (see ALISA help for details).
