# Edge by Ascential Test

This Repository is created for Test created by Edge. It has a custom comparator class which will be used to compare
the list of objects holding a number. The end goal is to search a given value using the custom comnparator and no other indexing/sorting
and hashing techniques

## NumberFinderImplementation
**Scenarios**
* Scenario 1 :
In this scenario we have used parellel streams to search the given number in the object. This is effective as the search should
executed on all the values and exit if found any. Hence this is a better approach as the size of the list increases
Time Complexity : O(n log n)

* Scenario 2 : In this scenario, (**would like to be noted here even though this method is not used**), We would note the start and end indicies and check till we get the value. This is a common linear search , however this would reduce the time taken and the worst time complexity woul be O(n - k) if the value is found to be in the middle +1 or middle -1, then the time taken would be the maximum time taken to asearch a value. Howvere not the best way for unsorted array if the array is huge.
Time Complexity : O(n -k)

## Support & Ownership

Feel free to ask [Sijumon Karyil Raju](sijuthomas1988@gmail.com) if you need some support when there are any questions left or if you need some support.