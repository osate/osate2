# AADL Style Guide

The following guidelines are suggested when using AADL for modeling a system.  They are recommended in case you want to use a consistent naming rules and also want to share your models with other AADL users.



## Files

### File Names

#### AADL Packages

An AADL file uses the file extenstion `.aadl`.

The basename of an AADL file is the name of the public AADL package it contains with the separator `::` replaced by the hyphen `-`.

> **Example**
>
> The public package `edu::sei::examples` is stored in the file `edu-sei-examples.aadl`.



#### AADL Property Sets

An AADL property set uses the file extenstion `.aadl`.

The basename of the property set file is the name of the property set it contains.

> **Example**
>
> The property set `basic_types` is stored in the file `basic_types.aadl`.



### Indentation

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



## AADL Entity Names

### Component Classifiers

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



### Features

The feature name should provide information about what the feature does or provide contextual information.

A `port` features should be prefixed by its direction (`in`, `out`, `in out`).

> **Example**
>
>     in_one_minute_passed : in event port;

> **Example**
>
>     out_cancelled : out event port;



### Connections

Connections should use the prefix `conn_` and reference the source and destination subcomponents.  If you have several connections between the same two components, try to differentiate them using a suffix related to the connection's function or context.

> **Example**
>
>     conn_src_dest : port src.out_cancelled -> dst.in_cancelled;

> **Example**
>
>     conn_thermometer_controller_temperature: 
