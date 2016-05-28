object ClosureTutorial{
	def main(args: Array[String]){

		def outerFunc(outerNum :Int ) = {
			val five = 5 * outerNum
			//create an anonymoust function
			(num : Int) => {num * five}
		}

		val func = outerFunc(2);
		//println(func);
		//Returned function, uses the value created in the outer method
		println("final value = "+func(3))
	}
}	
