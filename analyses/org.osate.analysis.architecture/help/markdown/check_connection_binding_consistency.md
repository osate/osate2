# Check Connection Binding Consistency
The objective of this analysis is to check that there is a physical connection between the hardware components related to the source and destination of a connection.

# Invoking the Analysis
 * Select an instance model in the **AADL Navigator**
 * In the main menu, select **Analyses** -> **Semantic Checks** -> **Check connection binding consistency**

![Main Menu Action](images/MainMenuAction.png)

# The Checking

The connection binding consistency check ensures that for each logical connection, e.g., a port connection, there is a physical connection via a bus between the related hardware components.

If the source or destination of a connection instance is a software component, e.g., a thread, then the related hardware component is the physical processor or system the software component is bound to.
If the source or destination of a connection is a device then the device is the related hardware component.


# Results

The results of the analysis are reported in a report in the folder "instances/reports/ConnectionBindingConsistency". 

The result report includes the following:

* Warning if one of the connection endpoints does not have a related hardware component.
* Error if there is no explicit connection binding and the two hardware components are not connected by a bus.
* Error if there is a connection binding to a single bus and neither the source nor the destination hardware is connected to the bus.
* Error if there is a connection binding to multiple hardware components and the source is not connected to the first bus or the destination is not connected to the last bus.  

