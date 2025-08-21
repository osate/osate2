<!--
Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file). 
All Rights Reserved.

NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.

This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
which is available at https://www.eclipse.org/legal/epl-2.0/
SPDX-License-Identifier: EPL-2.0

Created, in part, with funding and support from the United States Government. (see Acknowledgments file).

This program includes and/or can make use of certain third party source code, object code, documentation and other
files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
conditions contained in any such Third Party Software or separate license file distributed with such Third Party
Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
-->
# System Operation Mode Reachability Analysis

<!--[TOC levels=2-4 bullet hierarchy]-->

The system operation mode reachability evaluates the modes and transitions in an instance model to determine the set of SOMs that are reachable from the initial SOM and the transitions between SOMs. It takes into account the rules for operational modes stated in the AADL standard. Details of the analysis are described in an SEI technical report that can be downloaded from **[here](https://insights.sei.cmu.edu/library/reachability-of-system-operation-modes-in-aadl/)**. This report describes the analysis for a non-distributed system, where an event can trigger several mode transitions simultaneously. Component modes can be managed by a single mode manager in the runtime system that initiates mode transition as soon as a triggering event occurs.

The reachability analysis in OSATE extends this to the distributed case. In a distributed system, a mode transition trigger may originate in a remote system and arrive at the target system after a delay. In this situation the mode transition in the target system is triggered by the arrival of the event and no longer simultaneously with the event occurrence. The analysis requires the definition of *mode domains*, within each domain modes change at the occurrence of an event. Trigger events that arrive from another domain are treated like external events in the non-distributed analysis.

The distributed analysis discards cross-domain trigger events that cannot occur in the originating domain, i.e., because the originating component is never active.

## Specifying Mode Domains

The boolean property `SEI::Mode_Domain` can be used to mark a component as a mode domain by setting its value to `true`. Mode domains cannot be nested, and all modal model elements must be included in some mode domain. The analysis validates these requirements.

As a special case, if no component is marked as a mode domain, the analysis assumes that the system instance forms a single mode domain and runs the non-distributed version of the analysis.

## Running the Analysis

The analysis can be invoked by selecting an instance mode file in the AADL navigator. Right click, and select *Analyses* > *Semantic Checks* > *Analyze SOM Reachability*. 

The result of the analysis is a set of reachable SOMs and transitions between them for each mode domain. The SOMs of the overall system is, then, the parallel composition of these transition systems. The result is used to create (up to) three output files in directory *reports/som-reachability* in the instance model's directory. The report files for a system instance named `Package_System_i_Instance` are as follows:

 * `Package_System_i_Instance.dot`<br>
 This file is a source file for the program Graphviz, which can be used to convert the dot file to an image. The diagrams in the technical report were created this way. See the **[Graphviz web site](https://graphviz.org/)** for instructions. Alternatively, there are various extensions for the Visual Studio Code editor that provide a preview for dot files.
 * `Package_System_i_Instance.html`<br>
 This is an HTML file that can be rendered an any browser. It contains a description of the reachable SOMs and transitions between them.  
 * `Package_System_i_Instance.smv`<br>
 This file contains a translation of the SOM transition system to SMV and can be used in connection with the **[NuSMV](https://nusmv.fbk.eu/)** model checker for further analysis of the system's mode behavior.

Before running the analysis, the user can select which output files should be generated.
