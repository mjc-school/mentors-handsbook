## Big-O

* Topic is very complex, good course takes at least 20 hours
* Why should we care? nlogn vs n^2 sort comparison
* Big-O in math
    * Definition - f(x) growth not faster than g(x), so it's O(g(x))
    * Linear vs square graphs
    * Some properties
        * O(an + b) = O(n)
        * if f(x) = O(g(x)), then O(f(x) + g(x)) = O(g(x)). O(n + n^2) = O(n^2)
    * Popular complexities in order
        * 1, logn, n, nlogn, n^2, n^3
    * Selected properties of Big-O - ask students on examples
    * Questions? If you don't understand it at all, maybe in would be better on examples 
* Big-O in algorithms
    * Why we can't calculate how much time algorithm will take
    * Examples
        * Array max
            * Method call with input of size 1000 will work twice as fast comparing to the input of size 2000
            * Cycle has a O(n) complexity
        * Pairs - difference will be 4 times
            * Nested cycle has a O(n^2) complexity
        * Method call - difference will be 8 times
        * ArrayList "add" extention complexity
* Memory complexity
* General-case sorting - O(nlogn)
* Selected data structures
    * Stack, queue
    * Lists
    * Tree
    * Hash table
    * PriorityQueue
* FAQ
    * Constant in front of complexity can be very high, making algorithm inefficient
* Advanced data structures and algorithms
