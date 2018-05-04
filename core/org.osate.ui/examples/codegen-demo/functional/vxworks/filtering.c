#include "gtypes.h"

void filtering_spg
    (codegen_demo__datatypes__altitude val0,
     codegen_demo__datatypes__altitude val1,
	 codegen_demo__datatypes__altitude* valout)
{
	*valout = (int) ((val0 + val1) / 2);
}
