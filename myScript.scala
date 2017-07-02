println("My script")

var list1 = List(1,2,3,4,5)
println(list1.contains(3))

var list2 = List(1,2,3)

def Listadder(list1:List[Int],list2:List[Int]): Int = {

return list1.sum + list2.sum

}

println(Listadder(list1,list2))
