Copyright 2022 Carnegie Mellon University.
This material is based upon work funded and supported by the Department of
Defense under Contract No. FA8702-15-D-0002 with Carnegie Mellon University
for the operation of the Software Engineering Institute, a federally funded
research and development center.
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

DM22-0018

# ACVIP ALISA Example

This example is to demonstrate the basics of ALISA for the AADL/ACVIP tutorial.
It was originally designed by the Software Engineering Institute (SEI) at
Carnegie Mellon University (CMU) to demonstrate the following
capabilities of ALISA:

* Stakeholders
* Goals
* Requirements
* Verification

There's 2 folders presented in this example:

* A folder named "ALISA_Example" contains the goals, requirements, verification 
  plans, and stakeholders.
* A folder named "SCSProject" contains an AADL project that ALISA requirements
  are written for

### ALISA

Within the "ALISA_Example" folder, there are several types of files:

* "SEI.org" contains information about the stakeholders of the project
* "isolleteSystemCategories.cat" contains categories that can be assigned to a
  requirement to help group requirements together
* Files that end in ".goaldoc" allow you to specify goals for the project.
  There is currently only a single goal within "SCSFamilyGoals.goaldoc" but
  more will be added down the line. 
* Goals are referenced by requirements in the "SysReq.reqspec" file.
  Requirements can have variables that are then used for value assertion. The 
  file "SysVerify.verify" can help automate the verification process of the
  model
* "SysMethods.methodregistry" allows you to specify the method that is run by
  the verification plan. Currently, only manual verification is used for this
  example.

More information on ALISA is provided in OSATE's help contents.
