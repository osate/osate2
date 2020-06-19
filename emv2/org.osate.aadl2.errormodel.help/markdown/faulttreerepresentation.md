<!--
Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
# Documentation of the FaultTree Representation

[TOC levels=2-4 bullet hierarchy]

## Introduction

OSATE includes an Ecore model of the FaultTree representation. It can be found at [org.osate.aadl2.errormodel.faulttree](https://github.com/osate/osate2/tree/develop/emv2/org.osate.aadl2.errormodel.faulttree/model).

## FaultTree Object

The representation for the fault tree was designed to represent fault graphs. This allows us to reference common Events or event subtrees/graphs instead of having them replicated.
It does so as follows: 

* the top level model object *FaultTree* - contains a list of all events. In addition it identifies the Event that is the root of the fault tree/graph.

* Individual *Event* objects may reference subevents. If they do so an attribute indicates the type of gate associated with processing the subevents. In other words, we do not have an explicit *Gate* object since every event has all its subevents under a single gate.


The full representation of the FaultTree object is as follows:

* *name*: a human readable name usually a composition of instance model root and faulttree type used as file name
* *instanceRoot*: reference to instance model root object used to generate the FaultTree
* *root* : root event of the fault tree
* *events* : collection of all Events in the fault tree/graph
* *faultTreeType* : one of the four types of generated trees:

We have the following fault tree types corresponding to the four types of representations users can generate from the AADL model:

1. FaultTrace: full trace of the contributor paths
2.    FaultTree: flattened tree with transformations applied
3.    CompositeParts: RBD like analysis based on composite error state declarations
4.    MinimalCutSet: collection of cut sets.

## Event Object

The Event object has the following representation:

* *name*: human readable name typically reflecting the AADL model source of the *Event* - a combination of instance model element and EMV2 element. When transformations are applied the name may be a generic *Intermediate-xx* when as a result of the transformation the trace back into the instance model is not unique.

* *message*: textual description useful for displaying the representation of an event

* *subEvents*: collection of references to sub events

* *type*: Event Type (Basic, External, Undeveloped, Intermediate). This follows the types defined in the NRC Fault Tree Analysis handbook (NUREG-0492).

* *subEventLogic*: the gate logic to be used with the sub events (Or, And, Xor, PriorityAnd, KOf, KOrMore, KOrLess). KOf represents K out of n (n = number of subevents). It is sometimes referred to as voting gate. Xor is interpreted as 1-Of. 

* *k*: value of k for "K" operators

* *relatedInstanceObject*, *relatedEMV2Object*: traceability reference to identify the AADL instance/EMV2 object that is represented by the Event

* *assignedProbability*, *computedProbability*: assigned/computed occurrence probability

* *scale*: adjustment made to probability reflecting transition branch probabilities along the path.

* *referenceCount*: number of events referencing the given event as subevent.
    
## Generation of FaultTree Representations

We first generate a fault graph that is a full trace of contributing events to the root event of the desired fault tree. 

We then apply transformations according to the analysis the user has chosen. Finally, we calculate the occurrence probabilities for the events. See [EMV2 Mapping and Transformation sections](safetyanalysis.md) for more details.


## XMI Representation of FaultTree files

When the model is written out in XMI it uses the default representation for references (HREF).

That representation records the model element identified with an index within the list in which the Event object is contained. This means that a reference to @events.43 refers to the 44th element in the events list of the top-level object.
