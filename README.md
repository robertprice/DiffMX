# Diff
Mendix module for finding the differences in text.

This module exposes the following Java Actions

* Diff_Semantic
* Diff_PrettyHTML

## Java Actions

### Diff_Semantic

This Java Action will compare two pieces of text and return a list of Diff entities containing the differences. 

The Diff entity ocontains an Operation attribute and a Text attribute. 

The Operation can be either
* DELETE - if the text is deleted in the new text.
* INSERT - if the text is inserted in the new text.
* EQUAL - if the text is the same in both the original and the new text.

### Diff_PrettyHTML

This Java Action will compare two pieces of text and return a String containing some HTML showing the differences between the two texts. It is useful for debugging and quick visualisation.

## Unit Testing

If the Mendix UnitTesting module is installed, there are two unit tests exposed. One to test Diff_Semantic, and one to test Diff_PrettyHTML.

## See Also

This module uses Java code from [diff-match-patch](https://github.com/google/diff-match-patch)
