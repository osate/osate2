# Code Generation Checker
The objective of this plug-in is to check the model
semantics to generate code using the following
platforms:

 * POK
 * DeOS
 * VxWorks

# Invoking the Checker
 * Right-click on a System Implementation in the Outline view
 * Select **Code Generation** in the context menu
 * Select the appropriate checker for your system: POK, DeOS, or VxWorks

![Context Menu Actions](screenshots/OutlineActions.png)

# Results
Any problems that the checker finds are reported in the Problems view:

![Results](screenshots/CheckerResults.png)

# List of Rules

## Common Rules
 * **Data**: All data components must define the property *Memory_Properties::Data_Size*
 * **Process**: All process components must contain at least one thread subcomponent
 * **Process**: All process components must be bound to a virtual processor through the property *Deployment_Properties::Actual_Processor_Binding*
 * **Process**: All process components must define the property *Deployment_Properties::Actual_Memory_Binding*
 * **Thread**: All thread components must have a *Thread_Properties::Dispatch_Protocol* of *Periodic* or *Sporadic*
 * **Thread**: All thread components must define the property *Timing_Properties::Period*
 * **Thread**: All thread components must define the property *Timing_Properties::Deadline*
 * **Thread**: All of each thread's called subprograms must define the property *Programming_Properties::Source_Name*
 * **Thread**: All of each thread's called subprograms must define the property *Programming_Properties::Source_Text*
 * **Thread**: All of each thread's called subprograms must define the property *Programming_Properties::Source_Language*

## POK Specific Rules
 * **Memory**: All memory subcomponents contained within a memory component must define the property *Memory_Properties::Byte_Count*
 * **Processor**: All processor components must list all virtual processor subcomponents in the property *POK::Slots_Allocation*
 * **Processor**: For all processor components, the size of the property *POK::Slots_Allocation* must equal the size of the property *POK::Slots*

## DeOS Specific Rules
 * **Processor**: All processor components must define the property *ARINC653::Module_Schedule*
 * **Virtual Processor**: All virtual processor components must define the property *Timing_Properties::Execution_Time*
 * **Virtual Processor**: All virtual processor components must define the property *Timing_Properties::Period*

## VxWorks Specific Rules
 * **Processor**: All processor components must define the property *ARINC653::Module_Schedule*
 * **Virtual Processor**: All virtual processor components must define the property *Programming_Properties::Source_Name*