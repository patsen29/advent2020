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