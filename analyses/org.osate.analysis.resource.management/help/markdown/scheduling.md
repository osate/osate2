# Scheduling Analysis
The built-ins plug-in of OSATE supports three types of analysis related to scheduling:

* **Bind and Schedule Threads**: A binpacking resource allocation tool that ensures schedulability and binding constraints are satisfied. 
* **Schedule Bound Threads**: A rate monotonic analysis of periodic threads that are bound to processors.
* **Check Rate Monotonic Priority Assignment**: For periodic threads with assigned priority ensure the assigned priority adheres to RMA rules.

Other forms of scheduling analysis are provided by external tools. Examples are Cheddar <http://beru.univ-brest.fr/~singhoff/cheddar/> (available through AADL Inspector <https://www.ellidiss.com/products/aadl-inspector/>) and FASTAR <https://www.adventiumlabs.com/demonstration-framework-analysis-schedulability-timing-and-resources-fastar>.

# Invoking the Analyses
 * Select an instance model in the **AADL Navigator**
 * In the main menu, select **Analyses** -> **Timing** -> (**Bind and Schedule Threads** **Schedule Bound Threads** **Check Rate Monotonic Priority Assignment** 

# Results

The results of the analysis are shown in a report found in a subfolder of *instances/reports/*.

Any problems that the analysis finds are also reported in the **Problems** view.

# Bind and Schedule Threads Analysis

This analysis uses a binpacking technique developed as part of the Ph.D. thesis by Dio DeNiz. It allows the user to choose one of three allocation strategies. It takes into account RMA and EDF.

![Binpack](images/Binpacker.png)

Once the analysis is complete the user can see the results in a dialog and has the choice of having the binding stored in the instance model.

![Binpack](images/Binpacker.png)

In addition the results are kept in a report in the subfolder *BinPacking*. 

# Schedule Bound Threads Analysis

This analysis considers only periodic threads that are bound to processors.

The results are kept in a report in the subfolder *SchedulingAnalysis*. They are also shown in the **Problems** view.


# Check Rate Monotonic Priority Assignment

This analysis considers only periodic threads that are bound to processors and have an explicit priority assigned. The analysis reports any priority inversion. 

The results are shown in the **Problems** view.

# Execution Time Scaling across Processor Types
  
The compute execution time is specified with respect to a particular processor type. 
If the model uses more than one processor type the latency analysis scales the execution time accordingly.
This is done by looking for a specification of a Reference_Processor property value on the thread (or enclosing component) 
and taking the ratio between the Processor_Capacity of the physical processor the thread is bound to and the reference processor 
as scaling factor.

