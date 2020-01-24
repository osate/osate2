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
## <span id="style">AADL Style Guide</span>

The following guidelines are suggested when using AADL for modeling a system.  They are recommended in case you want to use a consistent naming rules and also want to share your models with other AADL users.



### Files

#### File Names

##### AADL Packages

An AADL file uses the file extenstion `.aadl`.

The basename of an AADL file is the name of the public AADL package it contains with the separator `::` replaced by the hyphen `-`.

> **Example**
>
> The public package `edu::sei::examples` is stored in the file `edu-sei-examples.aadl`.



##### AADL Property Sets

An AADL property set uses the file extenstion `.aadl`.

The basename of the property set file is the name of the property set it contains.

> **Example**
>
> The property set `basic_types` is stored in the file `basic_types.aadl`.



#### Indentation

Syntactic blocks should be indenteded in a consistent manner, using either spaces or tabs.

> **Example**
>
> Here is AADL text using 4-space indentaton.
>
>     process pr_example
>     features
>         in1 : in event port;
>         out1 : out event port;
>     properties
>         Property_Name => Property_Value;
>     end myprocess;



### AADL Entity Names

#### Component Classifiers

Start with the kind of the component.  Continue with a hint about the function/operation of the component.

> **Example**
>
>     process pr_receive_http_request

> **Example**
>
>     thread thread_gui_main

> **Example**
>
>     device implementation dev_keyboard.usb_impl



#### Features

The feature name should provide information about what the feature does or provide contextual information.

A `port` features should be prefixed by its direction (`in`, `out`, `in out`).

> **Example**
>
>     in_one_minute_passed : in event port;

> **Example**
>
>     out_cancelled : out event port;



#### Connections

Connections should use the prefix `conn_` and reference the source and destination subcomponents.  If you have several connections between the same two components, try to differentiate them using a suffix related to the connection's function or context.

> **Example**
>
>     conn_src_dest : port src.out_cancelled -> dst.in_cancelled;

> **Example**
>
>     conn_thermometer_controller_temperature: 
