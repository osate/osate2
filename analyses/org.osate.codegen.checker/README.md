# Code Generation Checker
The objective of this plug-in is to check the model
semantics to generate code using the following
platforms:
 * POK
 * DeOS
 * VxWorks


# List of Rules

## Common Rules
 * **Thread**: The property Dispatch_Protocol is set.
 * **Thread**: The property Dispatch_Protocol is periodic or sporadic.
 * **Thread**: If the property Dispatch_Protocol is set on Sporadic, there is at least one event or event data port
 * **Thread**: property period and deadline are set
 * **Thread**: check that subprograms being called define Source_Name
 * **Thread**: check that subprograms being called define Source_Text
 * **Data**: check that it defines Data_Size
 * **Process**: the process is bound to a virtual processor
 * **Process**: the process is bound to a memory

## POK Specific Rules
 * **Memory**: the memory defines the byte_count property
 * **Processor**: defines the slots_allocation properties and references all partitions
 * **Processor**: defines the slots property and is the same size than the slots_allocation

## DeOS Specific Rules


## VxWorks Specific Rules