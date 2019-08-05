# Scheduling Analysis
The built-ins plug-in of OSATE supports three types of analysis related to scheduling:

* A binpacking resource allocation tool that ensures schedulability and binding constraints are satisfied. 
* For periodic threads with assigned priority ensure the assigned priority adheres to RMA rules.
* A rate monotonic analysis of periodic threads that are bound to processors.

Other forms of scheduling analysis are provided by external tools. Examples are Cheddar <http://beru.univ-brest.fr/~singhoff/cheddar/> (available through AADL Inspector <https://www.ellidiss.com/products/aadl-inspector/>) and FASTAR <https://www.adventiumlabs.com/demonstration-framework-analysis-schedulability-timing-and-resources-fastar>.

# Invoking the Analyses
 * Select an instance model in the **AADL Navigator**
 * In the main menu, select **Analyses** -> **Timing** -> (**Bind and Schedule Threads** **Check Rate Monotonic Priority Assignment** **Schedule Bound Threads**

# Results

The results of the analysis are shown in a report found in *instances/reports/SchedulingAnalysis*.

Any problems that the analysis finds are also reported in the **Problems** view.

# Bind and Schedule Threads Analysis

This analysis uses a binpacking technique developed as part of the Ph.D. thesis by Dio DeNiz. It allows the user to choose one of three allocation strategies.

![Binpack](images/Binpacker.png)
