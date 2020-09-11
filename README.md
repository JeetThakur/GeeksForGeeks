# GeeksForGeeks
All the learning and practice and challenging problems done via the DSAA Course

## The folder structure:
- Each module is a folder for the content learnt during DSAA Course
- Each module has numerous src .java files specefic to the learning
- Each of this will be documented as we go ahead

## Modules:
## Mathematics

AbsoluteValue.java
-   Simple program using the Math.abs() function available

AdditionUnderModulo.java
-   This is exposing the forumala of (a+b)%m = ( a%m + b%m ) % m for numbers very large

Exactly3Divisors.java
-   This is a O(N^1/2*N^1/4) Time complexity solution a very fast approach
-   The program is aimed at finding numbers present in a range of numbers that only have 3 divisors including 1 and itself

## Bit Basic

LogBase2.java
-   This file is the best way to return the floor(log2(number)) for a long as a return type integer
-   Formula used is >> bit operator
-   Logic is to simply shift the bit till number is 1 the counter is the integer result of the floor(log(n,2))
-   O(1) Solution

IsPowerOf2.java
-   The classic interview basic see if the number is a power of 2 or not, the solution here is O(1)
-   The logic for any possible power of 2 is to have only a single bit value that is set
-   The same can be explored by subtracting the supposedly smaller number and then & that number if gives a zero meaning the number was only a bit set meaning power of 2 else not

HighestBitSet.java
-   This is a O(1) Solution
-   The approach uses a previously made LogBase2 utility function to generate the log2 of the number
-   The answer when raised to 2 generates the answer required

XORofAllNumbersInN.java
-   This is a O(1) Solution
-   The approach uses a hidden fact about xor property
-   Every multiple of 4 has the xor value in sequence as the value itself
-   Hence, number%4 -> remainder 0 = Number; remainder 1= 1; remainder 2 = Number+1; remainder 3= 0;

MaximumAndValue.java
-   This is a O(N LogN) solution
-   The idea is to sort the array in descending order then looping to find the first 2 repeating same log2 base values for the number
-   This re-uses the log2 utility created in the LogBase2.java file
-   The other approach is to create a bit set of 31 and then checking for the best or value for all numbers in O(N) but kindof gets confusing

FirstSetBit.java
-   This is a O(Log N) solution
-   The odd numbers are checked with the n & 1 if == 1 then we simply return 1
-   This leaves us with even numbers
-   Reducing all powers of 2 using the powerOf2 function we can check for the bit position directly
-   The leftover even numbers need to be checked for the first possible bit set by anding the number at each division with 1
-   The above checks still fail for 0 hence check 0 at first and return 0
