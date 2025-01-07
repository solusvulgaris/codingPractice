Your job, is to create a program, that converts 
a negative binary format number into the common decimal format.

A numeral system is based on the power of the base number, on a certain position (digit).
For example: The binary value of 101101 represents (from backwards):
- 1 multiplied by 2^0 => 1
- 0 multiplied by 2^1 => 0
- 1 multiplied by 2^2 => 4
- 1 multiplied by 2^3 => 8
- 0 multiplied by 2^4 => 0
- 1 multiplied by 2^5 => 32
  aka 1+4+8+32
  aka 45.

In the Negative Binary Numeral System, we use the power(s) of -2.

For example: The negative binary value of 101101 represents (from backwards):
- 1 multiplied by -2^0 => 1
- 0 multiplied by -2^1 => 0
- 1 multiplied by -2^2 => 4
- 1 multiplied by -2^3 => -8
- 0 multiplied by -2^4 => 0
- 1 multiplied by -2^5 => -32
  aka 1+4-8-32
  aka -35.

Might be useful:
- Input negative binary number only contains '0's and '1's
- Input negative binary number always starts with '1' (at the top digit).
  Input
  Line 1: A string N for the negative binary number
  Output
  Line 1 : The decimal value of the negative binary number