# GeeksForGeeks
All the learning and practice and challenging problems done via the DSAA Course

## The folder structure:
- Each module is a folder for the content learnt during DSAA Course
- Each module has numerous src .java files specefic to the learning
- Each of this will be documented as we go ahead

## Modules:
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

