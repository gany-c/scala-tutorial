object ScalaMapEg{
	def main(args: Array[String]){

	val employees = Map("Manager" -> "Bob Smith",
			"Secretary" -> "Sue Brown")

	if(employees.contains("Manager"))
		printf("Manager : %s\n", employees("Manager"))

	val customers = collection.mutable.Map(100 -> "Paul", 101 -> "Sally Smith")

	printf("Cust 1 : %s\n", customers(100))

	customers(100) = "Tom Marks"

	customers(102) = "Megan Swift"

	for((k,v) <- customers)
		printf("%d : %s\n",k,v)
	}
}	
