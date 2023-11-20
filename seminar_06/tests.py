import pytest

from main import MyList

def test_init():
   elements1 = [1, 2, 3, 4.4, 5.4]
   mylist1 = MyList(elements1)
   assert mylist1.elements == elements1

   elements2 = []
   mylist2 = MyList(elements2)
   assert mylist2.elements == elements2

   elements3 = ['abc']
   with pytest.raises(ValueError):
       mylist3 = MyList(elements3)


def test_average():
    my_list = MyList([1, 2, 3, 4, 5])
    assert my_list.average() == 3

    my_list = MyList([0])
    assert my_list.average() == 0

    my_list = MyList([-1])
    assert my_list.average() == -1

    my_list = MyList([])
    assert my_list.average() == 0


def test_compare_average_equal(capsys):
    list1 = MyList([1, 2, 3, 4, 5])
    list2 = MyList([6, 7, 8, 9, 10])
    list1.compare_average(list2)
    captured1 = capsys.readouterr()
    assert captured1.out == "Second list has a larger average value\n"

    list2.compare_average(list1)
    captured2 = capsys.readouterr()
    assert captured2.out == "First list has a larger average value\n"

    list3 = MyList([1, 2, 3])
    list4 = MyList([1, 2, 3])
    list3.compare_average(list4)
    captured1 = capsys.readouterr()
    assert captured1.out == "Average values are equal\n"