package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    println("Parentheses Matching")

    val s = "I told him (that it’s not (yet) done). (But he wasn’t listening)"	
    println(balance(s.toList))

    val t = "())("
    println(balance(t.toList));		 

 
    println("Coins and change")
    println(countChange(4,List(2,1)))	 		
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {

	if(c ==0 || r ==0 || c ==r)
		return 1
	else{

		return (pascal(c-1,r-1) + pascal(c,r-1));
	}
   }	  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {

	if(chars.isEmpty)
		return false;
	else if(chars.length==1){
		if(chars(0)=='(' || chars(0) == ')')
			return false;
		else
			return true;
	}
	else{
		return balance(chars,0,0);
	}
    }	
  

   def balance(chars: List[Char],start: Int, count: Int): Boolean = {

	var newCount = count;

	if(chars(start)==')'){
	  if(count==0)
		return false;
	  else
	     newCount = count - 1;	
	} else if(chars(start)=='('){
	     newCount = count +1;	
	} 


	if(start == chars.length -1){
		 println("reached the end of the string");
		if(newCount == 0){
			return true;
		}
		else{
			return false;
		}
	} else {
		
		return balance(chars,start+1,newCount);
	}
   }	

  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {

	if(money <= 0|| coins.isEmpty)
		return 0;

	println("--------------start---------");
	println("money = "+money)
	println("coins = "+coins)
	println("--------------end-----------");

	val firstCoin = coins.head;

	if(coins.length ==1){
	  if(money >= firstCoin && money % firstCoin ==0)
		return 1;
	  else 
		return 0;	
	} 
	else{
		var coinsMinusHead = coins.filter(_ != firstCoin);
		if(firstCoin > money){

			return countChange(money, coinsMinusHead);

		} else {
			var newMoney = money
			var sum = 0

			if(newMoney % firstCoin==0)
				sum = sum +1;

			while(newMoney > 0) {
                        	sum = sum + countChange(newMoney - firstCoin, coinsMinusHead);
				newMoney = newMoney - firstCoin;
			}
			sum = sum + countChange(money,coinsMinusHead);
			return sum;
 		}
	     }		

    }	
  }
