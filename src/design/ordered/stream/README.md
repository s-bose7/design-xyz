There is a stream of n pairs arriving in an arbitrary order. A pair consists of a unique ID and a value. 

The task is to design a stream that returns the values in increasing order of their IDs by returning a chunk of values after each insertion. The concatenation of all the chunks should result in a list of the sorted values.

For example, if we insert to the stream in this order:
(3, "ccccc") (1, "aaaaa") (2, "bbbbb") (5, "eeeee") (4, "ddddd")  
Then the output should be:                          

[]   
["aaaaa"]   
["bbbbb", "ccccc"]  
[ ]  
["ddddd", "eeeee"]  

![Visualization](visual.gif)
