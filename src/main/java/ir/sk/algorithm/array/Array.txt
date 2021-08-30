Array problems often have simple brute-force solutions that use 0(n) space, but
subtler solutions that use the array itself to reduce space complexity to 0(1).
Filling an array from the front is slow, so see if it's possible to write values from
the back.
Instead of deleting an entry (which requires moving all entries to its right), con¬
sider overwriting it.
When dealing with integers encoded by an array consider processing the digits
from the back of the array. Alternately, reverse the array so the least-significant
digit is the first entry.
Be comfortable with writing code that operates on subarrays.
It's incredibly easy to make off-by-1 errors when operating on arrays.
Don't worry about preserving the integrity of the array (sortedness, keeping equal
entries together, etc.) until it is time to return.
An array can serve as a good data structure when you know the distribution of
the elements in advance. For example, a Boolean array of length W is a good
choice for representing a subset of (0, 1, ... , W - 1]. (When using a Boolean array
to represent a subset of (1, 2, 3, ... , «}, allocate an array of size n + 1 to simplify
indexing.)
When operating on 2D arrays, use parallel logic for rows and for columns.
Sometimes it's easier to simulate the specification, than to analytically solve for
the result. For example, rather than writing a formula for the i-th entry in the
spiral order for an n X n matrix, just compute the output from the beginning.