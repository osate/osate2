Copyright 2022 Carnegie Mellon University.
This material is based upon work funded and supported by the US Army
Development Command Aviation and Missile Center under Contract No. 
FA8702-15-D-0002 with Carnegie Mellon University for the operation of the 
Software Engineering Institute, a federally funded research and development
center sponsored by the United States Department of Defense.
The view, opinions, and/or findings contained in this material are those of
the author(s) and should not be construed as an official Government position,
policy, or decision, unless designated by other documentation.

NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.

[DISTRIBUTION STATEMENT A] This material has been approved for public release
and unlimited distribution.  Please see Copyright notice for non-US Government
use and distribution.

* Internal use: Permission to reproduce this material and to prepare derivative
works from this material for internal use is granted, provided the copyright
and "No Warranty" statements are included with all reproductions and derivative
works.
* External use: This material may be reproduced in its entirety, without
modification, and freely distributed in written or electronic form without
requesting formal permission. Permission is required for any other external
and/or commercial use. Requests for permission should be directed to the
Software Engineering Institute at permission@sei.cmu.edu.

These restrictions do not apply to U.S. government entities.

DM22-0114

# ACVIP Example

This example is the Sensor Control System (SCS) example presented in the
AADL/ACVIP video tutorial ([available on YouTube](https://youtu.be/UQ9dWhLws-Q)).
It was originally designed by the Software Engineering Institute (SEI) at
Carnegie Mellon University (CMU) to demonstrate the following
capabilities of OSATE:

* Check Flow Latency

This model can be incrementally built upon to demonstrate multiple levels of
complexity within an AADL model, as well as the ability to run an analysis on
a model early in the development process. As the model becomes more complex,
the same analysis can be rerun to ensure the project is staying on track and 
more analysis will become valuable to be run on the model.

More information on the Architecture Centric Virtual Integration Process (ACVIP)
can be found via a conference paper from [SEI's Digital Library](https://resources.sei.cmu.edu/library/asset-view.cfm?assetid=634965). 

This model and README is based on OSATE 2.9.1.

### Organization of the example

There is one model contained within this project, along with a diagram of 
the HighLevelSCS implementation. 

### Creating a diagram

Although a diagram is already contained inside of this example project,
additional ones can be generated. To generate additional diagrams,
open InitialSCS.aadl, right click on the HighLevelSCS implementation in the
Outline perspective and select "Create Diagram...". The resulting diagram may
be somewhat different in appearance to the provided diagrams in the example if
using a newer version of OSATE.

### Conducting analysis

To analyze the model start by right clicking on the HighLevelSCS implementation
in the Outline perspective and select "Instantiate". The instantiation is placed
in the instance folder within the model in the AADL Navigator. Click the
instantiation (e.g., InitialSCS_HighLevelSCS_i_Instance.aaxl2) and then select
the Check Flow Latency (e.g., from the Analyses menu under the Timing submenu).

![png](images/CheckFlowLatency.png)
