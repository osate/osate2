# References

## from types

  * to other type
    * local
	  in same expr library or subclause, referenced by simple name
    * global
	  defined in library: `pkg::type`
  * to classifier
	classifier names are global: `pkg::comp.impl`
  * to meta class
    like applies to in property definitions
  * to property / property type
    names are global: `ps::prop`
  * name clashes:
    * e.g., if AADL package `P` defines component type `T` and expression type
	`T`, then `P::T` could refer to both. <p>
	Choose expression type by default, use `^P::T` to skip lookup in annex 
 
## from expressions

  * to variable
    * local
	  in same expr library or subclause, referenced by simple name
    * global
	  defined in library: `pkg::val`
  * to classifier
	classifier names are global: `pkg::comp.impl`
  * to subcomponent
    `this...`
  * to record field
    `variable.field`
  * to property of a component
    `#prop`
  * name clashes:
    * 
    
  * 
	
