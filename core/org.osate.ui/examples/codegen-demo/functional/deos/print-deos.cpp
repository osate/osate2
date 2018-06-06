/**
 * This file should be used for DeOS only.
 * This helps to print integer or strings.
 */

#include <string.h>
#include <videobuf.h>
#include <stdlib.h>


VideoStream VideoOut1(3, 3, 1, 77);  // specify 2 rows of output
VideoStream VideoOut2(2, 3, 1, 77);  // specify 1 row of output

extern "C" void print_str(const char* str)
{
	VideoOut1 << str << "\n";
}

extern "C" void print_int(const int foobar)
{
	VideoOut2 << foobar << "\n";
}
