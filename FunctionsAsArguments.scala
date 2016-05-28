object FuctionsAsArguments{
	def main(args: Array[String]){
	
	// here the function is both
	// defined with its interface and with its 
	// implementation
	def times3(num :Int) = num * 3
	
	// here the function is passed as an argument to another function
	// the argument is defined as taking in an int and then returning a double
	def multIt(someMethod: (Int) => Double, num:Int) = {
		someMethod(num)
	}

	printf(" 3 * 100 = %.1f\n", multIt(times3, 100))
	
	}
   }
	
