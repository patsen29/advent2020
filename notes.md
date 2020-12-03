# Day 1
The quick and dirty approach is to loop over both numbers. But, that's O(n²). That said, once we know the first number, 
we know what the second number should be, so we can just see if it`s in the list.

I went with a sorted set. I can read numbers one at a time, see if its complement number is in the set, and add it 
if it isn't. That's O(n log n) from the loop and search.

For the second part, I tried to see if I could generalize the inner part to find any pairing. 
Then, I can loop over the first number, still building the set as we go, and search for pairs.
That should be O(n² log n). 

We could probably generalize that even further, by having the inner search recurse to find tuples of any size 
greater than 2. But that might go to O(n!) unbounded. It would make for cleaner code though.

# Day 2
This looks like some basic string checking. The tough part is probably parsing the input itself, 
so I went with a regex. Pattern matching in Java is pretty clunky, but it beats writing my own parser.

For regex, I like https://www.debuggex.com/ to help me write them and see what I'm doing.

As for Big O notation, I need to count characters anyway, so looping over the string as chars seems fine.

For the second half, we just need to change the logic a bit. The one-indexing and remembering the xor operator (^)
are the main issues. 

It's not hard to create a second function to check the new logic on the same input. But it's a bit awkward to do both
at once. So, I made a data class for the parsed request, and allowed both functions to work on that input. The file
format is the same, so the same data structure should be fine.

# Day 3
This involves keeping track of a 2D map of tiles, and the map wraps horizontally, 
so we can use modular arithmetic for that. 
The file reader I'm using gives me a List of Strings, which is sort of a 2D array, given Strings are arrays of chars.
So I can keep that as the map format, and then loop over rows, counting how many trees are in the way.