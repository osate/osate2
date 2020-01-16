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
# Introduction

Architecture-led Incremental System Assurance (ALISA) is an incremental
life-cycle assurance workbench for high-assurance software-reliant
systems. It utilizes architecture abstractions in models to manage
requirements across multiple layer of a system architecture and the
verification of a system implementation against these requirements. The
workbench complements the capabilities of an architecture-centric
virtual system integration workbench for the development of such
systems.

Alisa utilizes SAE AADL as an architecture modeling language. Alisa
provides several notations for users to specify requirements,
verification plans, and execute verification plans incrementally
throughout the life cycle.

A paper describes the capabilities of ALISA
\[<https://hal.archives-ouvertes.fr/hal-01289468>\]. Other papers
include the use of ALISA in safety analysis
\[<https://hal.archives-ouvertes.fr/hal-01292290/>\] and two case study
reports on the Joint Multi Role (JMR) Tech Demo program
\[<https://resources.sei.cmu.edu/library/asset-view.cfm?assetid=447176>\]
and
\[<http://resources.sei.cmu.edu/asset_files/specialreport/2015_003_001_447187.pdf>\].

Incrementally Evolving and Maintaining the Assurance Evidence

## ALISA Concepts and Notations

We have introduced several notations in support of incremental lifecycle
assurance.



* ReqSpec: a notation for specifying stakeholder goals and system requirements. 


* Verify: a notation for registering verification methods, specifying verification activities, and verification plans with claims that requirements are satisfied by the results of verification activities. 


* Alisa: a notation for defining assurance cases that consist of one or more assurance plan. An assurance plan configures the assurance of a particular AADL instance model and related artifacts and specifies how many subsystems are included in the given assurance case. Assurance tasks define a filtered view of the assurance case based on category labels that allows users to focus on a high priority subset of requirements and verification activities. 


* Assure: a notation that represents an assurance case result instance, i.e., the assurance evidence as the result of executing verification plans on one or more system instance models. Assure instances in this notation are automatically generated for an assurance case and a filtered view based on specified categories (assurance task). 



These notations are supported by additional notations:



* Organization: a notation for defining the stakeholders of a system. 


* Categories: a notation for defining different types of categories. These categories can be used to characterize requirements, verification activities, and verification methods. Users can filter assurance case viewing and automated verification by filtering on these categories.
 A set of category types are predefined: requirement kind (such as assumption, guarantee), quality (e.g., safety, security, latency), development phase, and tier in an architecture layer.


> Note: All the notations in Alisa are case sensitive.

## Grammars and Notational Conventions

The notations use a simple syntax and are case sensitive. Each construct
introduces an instance of a particular Alisa concept, which we will
refer to as *entity*, and identifies it with a unique name. The name is
a simple identifier or a &lt;dot&gt; separated identifier sequence.
Entities in a container, such as a requirement in a system requirements
container, are qualified with the name of a container entity.

As the identifier may take the form of a label such as Req1, each entity
optionally also has a title field that provides a short descriptive
label. This label may be used instead of or an addition to the
identifier for presentation in views.

An entity may identify a model element that it is associated with.

An entity may contain a number of attributes, i.e., labeled values or
references to other model elements. These are enclosed in square
brackets.

When describing the syntax of Alisa notations we will use BNF-like
syntax markers to indicate optional constructs



* ( construct )? for an optional construct, 


* ( construct )* for a construct repeated zero or more times, 


* ( construct )+ for a construct repeated one or more times, and 


* a | b to represent alternatives. 


Grammar rules are labeled by *&lt;conceptname&gt; ::=* and rules may be
referred by *&lt;conceptname&gt;*. The reference means that the
construct is to be inserted in place as nested entity within another
construct.

We use the following approach for cross references:



* References to AADL classifiers use the AADL2 syntax to qualify the classifier name with the package name, e.g., my::pack::sys.impl for a system implementation reference. 


* Within requirements the user may reference a feature within a classifier. this is done by the feature name, which is resolved relative to the classifier reference of the enclosing Requirement specifications container. 


* References to objects in the Alisa languages, e.g., requirements and goals, use a "." separator in the qualified name path, e.g., systemreqs.r1. This includes references to verification activities, verification methods, verification plans, and to stakeholders. In many cases the references do not have to be qualified as the context uniquely identifies to target. For example, the requirement reference of a claim is within the scope of the system requirements container identified by a verification plan. 


* User defined categories are globally known by their name. Categories of different kinds (requirement, verification, selection) can use the same name as they only have to be unique within their kind. 

