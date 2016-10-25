The latency analysis plugin provides minimum (best case) and maximum
(worst case) latency time for each end-to-end flow of an architecture.
The plugin supports end to end latency analysis at various levels of
abstraction and fidelity. The fidelity of the analysis is determined by
the details in the AADL model and by some preference settings. The
plugin outputs the results in a spreadsheet document that shows the
final result (best/worst case latency) and the details of each latency
contributor.

The Basics
==========

The General Latency Analysis Model
----------------------------------

Worst-case and best-case end to end latency is calculated for each of
the end-to-end flows defined in an AADL model. The analysis is performed
in the instance model and the result are recorded in a report.

An end-to-end flow is a path through an alternating sequence of
components with flow specifications and of connections. Users can
architecture models with various levels of hierarchical nesting with
latency property values on component flow specifications and
connections. Users can add periodic sampling characteristics, add queue
size properties, size of data types communicated through ports,
execution times and deadlines for threads and devices, partitions with a
major frame period and detailed partition schedules, protocols and
networks with transmission latency based on a latency property value or
based on the size of data being transmitted.

The latency analysis takes into account the following latency
contributions:

-   Components contribute processing latency and sampling or
    queuing latency. Sampling latency is affected by whether connections
    are declared to be immediate (mid-frame) or (frame) delayed.
-   Partitions contribute partition output latency and latency in terms
    of major frame offset.
-   Connections contribute communication latency. It is determined by
    the components (virtual bus, hardware components) that the
    connection is bound to.

**Note**: An end to end flow may include components without a flow
specification.

The Preference Settings
-----------------------

The latency analysis offers several preference settings that affect how
latency is calculated. This allows users to perform trade studies along
certain dimensions without changing the model. The preference settings
can be found under the menu *Window/Preferences* then *OSATE
Preferences/Flow Analysis*. The latency analysis supports the following
settings:

-   **Treat as synchronous or asynchronous system**. Used to assess the
    latency of component not inherently synchronous or asynchronous as
    one or the other. Different hardware components are
    considered asynchronous. Software components bound to the same
    processor are considered synchronous. This is relevant when sampled
    processing occurs.
    -   **Asynchronous system (AS) \[default\]**: The components are not
        time synchronized, i.e., dispatches may have time shift.
    -   **Synchronous system (SS)**: The components are time
        synchronized, i.e., periodic dispatches are aligned
        across systems.
-   **Partition output policy**. Used to reflect different
    inter-partition communication policies in partitioned systems.
    -   **Major Frame delayed (MF) \[default\]**: assume that
        inter-partitions connections are flushed/realized at the end of
        the major frame. If a task in partition A sends a data to a task
        in partition B, the fresh data will be available only after
        completion of all remaining partitions, regardless the execution
        order of partition A or partition B.
    -   **Partition End (PE)**: assume that inter-partitions connections
        are available at the end of the partition whose task sends data.
        If a task in partition A sends a data to a task in partition B,
        the later will receive the data in the same major frame if
        partition B is executed after partition A.
-   **Worst-case processing time**: Users can choose between deadline
    and worst-case execution time as worst case processing time.
    -   **Maximum Compute Execution Time (ET) \[default\]**: Maximum
        compute execution time represents the completion time on the
        assumption that the task has immediate access to the processor
        and is not preempted. Useful when tasks execute on a static
        time line.
    -   **Deadline (DL)**: Deadline represents the worst-case completion
        time assuming the tasks are schedulable.
-   **Queuing latency on incoming ports**: Affects how the best case
    queuing delay is determined.
    -   **Assume empty queue (EQ) \[default\]**: No delay as the queue
        is assumed to be empty.
    -   **Assume full queue (FQ)**: Use minimum compute execution time
        times the queue size to determine the best case queuing time.
-   **Data set processing (DS) yes/no \[default no\]**: allows the user
    to specify a per element execution time and separately the size of
    the data set. The Data\_Model::Dimensions property of the port data
    type is interpreted as the size of the data set.

Additional preferences affect whether a subtotals column is included in
the report, and whether detailed result messages are also shown as
Eclipse Markers (result summaries are always also shown as Eclipse
Markers visible in the Problems view.

Invoking the Latency Analysis
-----------------------------

To use the plugin, select a system instance and select *Check Flow
Latency* in the *Analyses* menu, the *AADL Analyses* context menu, or
the icon with the green letter *F* in the toolbar.

Once the analysis is finished, a report is produced in a a directory
called reports/latency. The directory is available in your workspace, at
the same location as your instance model file.

The Reports
-----------

### Report Names and Location

Latency analysis reports are produced in a folder called
reports/latency. This folder can be found in your workspace folder that
contains your instance model. The report names include an indication of
the preference settings using the two letter labels shown above. This
allows users to maintain copies of reports with different preference
settings.

The latency analysis generates the report as a csv file and as a xls
file. Both reports contain the same information but the xls file
utilizes Excel formatting features (color-coding of results and separate
sheets for different end to end flows).

**Note**: If your installation of Eclipse (OSATE) does not recognize the
xls extension, you can add it yourself. Under Window/Preferences go to
General/Editors/File associations and add \*.xls as file type, and then
for this selected file type associate the editor by clicking on Add
select External programs and pick the Microsoft Excel Worksheet.

### Report Content

Report results include a column for minimum specified and maximum
specified latency (reflecting the lower and upper bound of the latency
property value).

A second set of columns represents the actual value (**min value** and
**max value**) used in the end-to-end latency calculation. These columns
use the most detailed values available in the model. This may be an
execution time value or period value or a specified latency value if no
other information is available. The method column indicates whether the
actual value represents

-   a specified value (latency property value),
-   processing (based on compute execution time and deadline),
-   transmission (based on latency property value on virtual bus or bus,
    or transmission time and data size property values),
-   queuing latency (based on queue size and execution time property
    values),
-   sampling latency (based on period property values),
-   partition latency (based on major frame and partition schedule
    property values).

Further details about how the actual latency value is calculated see the
sections below.

The comments column provides additional detail on the calculations and
may give warnings or error messages to report inconsistencies.

If connections are bound to virtual buses and buses, then those
components are shown in parentheses “()”. Their latency numbers add up
to the latency number shown as actual for the connection.

**Note**: The report also provides a summary evaluation of the results.
For the maximum latency an error message indicates if the actual exceeds
the expected maximum latency. For the minimum latency, the summary
report distinguishes between better than specified minimum end-to-end
latency, and whether the actual latency variation between minimum and
maximum exceeds the specified expected variation.

Examples
--------

Example models exercising the latency analysis can be found on
<http://www.github.com/osate/examples>.

Check out *latency-case-study* and *coreexamples/flowlatencyexamples*.

Specified Processing and Communication Latency Contributions
============================================================

The *Latency* property allows user to associate a latency value with
flow specifications of components and with connections. It takes a time
range value (minimum and maximum latency). It can be associated with

-   flow specifications (flow sources, flow paths, and flow sinks) of
    components to represent processing latency contributed by
    the component.
-   connections to represent communication latency.

Users can perform end-to-end latency analysis on a system based on these
latency specifications. They can do so for a system with one layer of
subsystems, or subsystems expanded by additional layers of the
architecture hierarchy. Different subsystems can be expanded to
different levels of the hierarchy. Examples of such models are
representing conceptual, functional, and task architectures.

The analysis will calculate the minimum and the maximum end-to-end
latency by adding up the specified latencies of all the component flow
specifications and of the connections. Absence of a latency property on
connections or flow specifications (or the absence of a flow
specification on a component) is interpreted as a latency value of zero
unless the model includes additional information from which to derive
the latency contributions (see next sections).

**Note**: This simple end-to-end flow latency model does not take into
account any sampling, queuing, or partition latency contributions.

Latency Contributions by Periodic Sampling Processing
=====================================================

In embedded systems it is common to perform periodic processing.
Examples are displays refreshing at a specified rate, sensors sampling
the physical environment at a given rate, application systems processing
their input periodically (periodic threads), networks transferring data
periodically (e.g., CANBus).

The *Period* property allows users to specify the time interval at which
a component executes. We can annotate a system, abstract, process,
thread group, thread, device, component with a period. Note that
hardware components can also contribute sampling latency (see later
section).

An end to end flow latency is determined by the sum of processing,
communication, and sampling latencies. For non-sampling components the
sampling latency is zero.

**Note**: In the case of a thread or device with a *Timed*
Dispatch\_Protocol the period value is interpreted as the time out value
and not interpreted as sampling latency contribution.

Sampling latency contributions are affected by whether two sampling
processing units are dispatched against the same clock (synchronous
systems) or against different clocks (asynchronous system).

Asynchronous Sampling
---------------------

In the asynchronous case, the worst-case sampling latency contribution
of a sampling processing unit is its period. This is the case when the
data arrives just after the periodically sampling unit has been
dispatched. The best-case sampling latency contribution is zero. This is
the case when the data arrives just before the sampling unit is
dispatched.

Synchronous Sampling
--------------------

In the synchronous case, the sampling latency can be reduced. The second
sampling unit is dispatched at the same time as the first sampling unit,
i.e., their dispatch times are aligned. In this case, the sampling
latency contribution is the difference between any processing and
communication latency since the first sampling unit and the next period
of the second sampling unit - effectively rounding up to the next
period.

**Note**: The effect of synchronized sampling is that the sum of
processing/communication and sampling latency is the same for the best
and worst case calculation. For example, a periodic (I/O) task is
sampling sensor input. The input is then processed by non-sampling tasks
to minimize latency. To manage the cumulative latency variation (jitter)
the output is sent to the actuator by the same I/O task at the beginning
of the next frame. In other words, the I/O task acts as jitter buffer.

**Note**: The first sampling unit may be followed by non-sampling units
before the second sampling unit. In this case the sum of processing and
communication latencies is rounded up to the next multiple of the second
sampling unit period.

**Note**: The cumulative processing and communication latency for the
best case and worst case may round up to different multiples of sampling
frames (period of the second sampling task). This results in frame-level
jitter even if the min/max cumulative processing latency differs only by
a few micro seconds, e.g., if one value just below and the other just
above a multiple of the sampling frame.

**Note**: If the first sampling task is followed by an asynchronous
sampling task then the processing latency and the period as sampling
latency are added. This task then becomes the first sampling task for
potential synchronous sampling.

When do we have Synchronous Sampling
------------------------------------

Different physical components, e.g., devices, processors, and buses are
considered to operate asynchronously, while software components on the
same processor are considered to operate synchronously.

**Preference note**: A preference setting lets users choose whether
components that have no indication of being synchronized, i.e., on the
same processor, or are inherently asynchronous, i.e., different hardware
components, should be handled as if synchronous or asynchronous.

**Note**: In the future we will also interpret the *Reference\_time*
property to recognize whether hardware components operate synchronously.

Execution Times and Deadlines as Latency Contributors
=====================================================

Users may have specified a *Deadline* property value for components.
This property represents the upper bound of worst-case completion time
as long as the component is deemed as schedulable.

Users can specify *Compute\_Execution\_Time* property values for threads
and devices. The maximum value is used if the preference setting is set
accordingly (see below). The minimum value is used for best-case latency
analysis.

**Note**: The compute execution time value does not necessarily
represent the best/worst-case completion time. It represents the best
case scenario of a thread executing first, without preemption, and
without executing a recovery handler, in other words a best case lower
bound.

**Note**: The latency analysis tool only considers explicitly set
Deadline values. By default the Deadline is set to be the Period value -
the latency analysis interprets this as if the deadline is not set.

**Preference note**: The preference setting lets the user choose between
using maximum execution time and deadline as the worst-case latency
contribution.

Mid-frame and Frame-delayed Communication
=========================================

The AADL thread model supports specification of immediate, and delayed
connections between sampling units (periodic threads and devices).

-   An immediate connection means that although both tasks have the same
    dispatch time the second tasks waits for the completion of the
    first task. This corresponds to mid-frame communication in a
    Simulink control model.
-   A delayed connection means that the second task always receives the
    output in the next sampling period, i.e., it is
    always frame-delayed. This ensures that for both the minimum latency
    and maximum latency we have a sampling latency of the second
    task period.

Connections between periodic tasks are considered to be sampling
connections if not specified as immediate or delayed connection. This
means that a receiving periodic task will sample at its dispatch time,
which may lead to frame-level latency jitter, as discussed earlier.

In a sequence of periodic tasks with immediate connections the deadline
of the last task becomes the deadline of the sequence, i.e., the
cumulative completion times must be within the deadline.

This leads to a minimum cumulative processing latency of the sequence as
being the sum of minimum flow specification latency or the sum of
minimum compute execution times. The maximum latency is the sum of
maximum flow specification latencies or maximum compute execution time
for each task.

**Preference note**: A preference setting lets the user choose between
using maximum execution time and deadline (of the last task) as the
worst-case latency contribution.

**Note**: A sequence of periodic tasks with immediate connections is
similar to a periodic task followed by data-driven (aperiodic) tasks.
The difference is that in the case of a sequence of aperiodic tasks each
task execution time has to meet its own deadline, i.e., the cumulative
maximum processing latency is bounded by the sum of task deadlines
rather than the deadline of the last task.

**Note**: Immediate and delayed connection assure deterministic up and
down sampling of tasks with harmonic periods. This means that a sensor
providing readings at 50ms to a processing task operating at 100ms, the
processing task will always see every other signal (or if the signals
are queued will always see two signals in the queue). The effect is that
this sampling pattern does not introduce additional noise into the
signal.

**Note**: Immediate and delayed connections are typically not supported
across synchronization domains, i.e., across processors and devices
operating on independent clocks - unless clock drift is bounded and a
Physically Asynchronous Logically Synchronous (PALS) protocol assures
task dispatch level synchronicity.

Communication Latency Contribution by Transfer Mechanisms
=========================================================

In this section we discuss how latency contributions can be associated
with communication transfer mechanisms that connections are bound to,
i.e., virtual buses, buses, device, systems, and abstract components.

Communication Latency Specifications for Protocols and Networks/Buses
---------------------------------------------------------------------

Users can indicate the intended transport mechanism via the
*Actual\_Connection\_Binding* property or
*Required\_Virtual\_Bus\_Class* property.

The latency analysis will take into account every element of an
*Actual\_Connection\_Binding* as latency contributor. In the case of a
virtual bus the analysis also includes the entities that the virtual bus
is bound to according to its *Actual\_Connection\_Binding* property
value. If the virtual bus or connection does not have a specified
*Actual\_Connection\_Binding* property value, then the
*Required\_Virtual\_Bus\_Class* property values are interpreted as
latency contributors.

The *Latency* property value of these components becomes the latency
contribution.

A bus or virtual bus can have a *Transmission\_Time* property value. It
specifies a fixed time and a per byte time latency contribution. If this
property is present and the sending port has a data type with a
*Data\_Size* property value, then the communication latency contribution
is calculated from these values instead using the *Latency* property
value associated with the virtual bus, bus, or other component the
connection is bound to.

More than one protocol may be involved in the connection communication,
e.g., one protocol may use a second protocol to perform its transfer.
The latency analysis adds each of the protocol latency contributions to
the total. This allows users to specify latency overhead being added by
each protocol. This overhead may be fixed or dependent on the size of
the content.

**Note**: If the connection has no binding, but the connection end
points are bound or are devices, then the latency analysis attempts to
determine the buses that connect the two hardware components between the
endpoints.

**Note**: If the connection has no connection binding or required
virtual bus, or those contributions are zero, then the *Latency*
property value attached to a connection is used as latency contribution.

Periodically Sampling Buses and protocols (virtual buses)
---------------------------------------------------------

Buses and virtual buses may operate periodically. For example, a CANBus
operates on a static time line with fixed slots for different transfer
actions. This is specified by associating a Period property value with a
virtual bus, bus, or other component acting as transfer mechanism. In
this case a sampling latency is added for every connection that is bound
to such a bus.

When reflecting the sampling effect of communication the rules for
asynchronous and synchronous sampling latency calculation and for
determining whether synchronous sampling occurs apply here as well. In
the synchronous case sampling latency contribution may be reduced from
the full sampling period.

**Note:** When several protocols or the bus have a sampling period
specified, the largest sampling period is used as it determines the
transmission rate.

Queuing Latency Contributions
=============================

AADL has event and event data ports that are queued ports. The port
includes properties to specify the queue size (*Queue\_Size*) and
policies for processing the queue.

The worst-case queuing latency the latency analysis assumes a full queue
and uses the product of the queue size and the worst-case execution
time.

**Preference note**: The deadline may be used if specified by Preference
Settings DL. For the best-case queuing latency the latency analysis
either assumes an empty queue (EQ) or full queue (FQ) using minimum
execution time (as specified by Preference settings).

**Note**: In the case of a periodic or sporadic task with a queue the
period is used instead of the worst-case or best-case execution time to
reflect the fact that queue processing is paced at the rate specified by
the period.

**Note**: In the case of a periodic or sporadic task with a queue the
queue size is reduced by one in calculating the queuing latency to
reflect the fact that the sampling latency of the periodic recipient
accounts for one element.

Partitioned Systems
===================

Partitioned systems use the concept of virtual machine (represented by
AADL virtual processor) to enforce address space protection of processes
at runtime.

In their simplest form partitions can be modeled by associating a
*SEI::isPartition* property and a *SEI::Partition\_Latency* property to
specify the time period of partition execution. This property can be
associated with a process or abstract component containing threads. In
this case the user does not have to explicitly model a partition using
virtual processor components.

The user can also use virtual processors to represent partitions.
Virtual processors can be declared as subcomponents of processors, or
they can be bound to processor. The latency analysis tools handles both
modeling styles.

The *SEI::Partition\_Latency* property can be used to specify the
partition major frame for a virtual processor.

Alternatively, the user can specify *ARINC653::Module\_Major\_Frame* on
a processor to which partitions are bound. The user can also specify a
full partition schedule using the *ARINC653::Module\_Schedule* property,
whose value is a list of records with the *Partition* field referring to
the partition and the *Duration* field indicating the window size.

The latency analysis will use the ARINC653 partition schedule
information, the ARINC653 major frame information, or the SEI Partition
Latency information in this order.

Partitions contribute two types of latency: partition output delay, and
partition start delay.

Partition output delay is due to the partition flushing its output at
the major frame or at partition end.

Partition start delay is due to a partition being scheduled in a
particular partition schedule window, or because of the alignment of the
partition major frame. In the latter case the latency analysis
distinguishes between synchronous and asynchronous cross-partition
communication. The same rules about alignment calculation as for sampled
processing apply.

**Preference note**: A preference setting lets the user choose the
partition major frame or the partition end as the time at which the
output is flushed.

**Note**: The latency of tasks within a single partition are calculated
as before. However, when communication occurs across a partition
boundary, communication is delayed until the next frame - determined by
the partition period, or until the partition end output and the
alignment between the sending and receiving partition - using the
partition schedule or major frame property values.

**Note**: A thread may have a period that is a multiple of the partition
major frame. The latency analysis takes into account the additional
sampling delay of the thread.

**Note**: Choosing the major frame as partition output assures that end
to end latency is not affected by a change in the order in which
partitions are allocated to a processor.

Latency Analysis and Modes
==========================

Latency analysis takes into account modes. It executes the analysis for
each of the modes. If you have mode-specific end-to-end flows or
mode-specific property values you will get mode-specific results.

**Note**: the analysis is currently not smart enough to avoid executing
for all possible modes if and end-to-end flow is not affected by modes.
