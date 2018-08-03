#include <gtypes.h>

codegen_demo__datatypes__altitude const_alt = 0;

void sensor_simulation
    (codegen_demo__datatypes__altitude* alt)
{
	*alt = const_alt;
	const_alt = const_alt + 1;

	if (const_alt > 100)
	{
		const_alt = 0;
	}
}
