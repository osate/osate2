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
