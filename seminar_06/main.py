"""
This module defines a class for calculating and comparing averages of lists.
"""
class MyList:
    """
    A class representing a list of numbers.
    """

    def __init__(self, elements):
        """
        Initialize a MyList object with a list of numbers.
        """
        if not all(isinstance(element, (int, float)) for element in elements):
            raise ValueError("All elements must be integers or floats.")
        self.elements = elements

    @classmethod
    def average(cls, elements):
        """
        Calculate the average of a list of numbers.
        """
        if not elements:
            return 0
        return sum(elements) / len(elements)

    def compare_average(self, other):
        """
        Compare the average of this list with another list and print the result.
        """
        average1 = self.average(self.elements)
        average2 = other.average(other.elements)
        if average1 > average2:
            print("First list has a larger average value")
        elif average2 > average1:
            print("Second list has a larger average value")
        else:
            print("Average values are equal")
