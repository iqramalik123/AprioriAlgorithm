import java.io.File
import java.io.PrintWriter
import scala.io.Source
object Apriori {
 def main(arg:Array[String]): Unit ={
    var config_file = Source.fromFile("C:\Users\Iqra Malik\workspace\Assignment1\config.txt" ).getLines.toList
    var t_items = config_file(0).toInt + 1
    var t_trans = config_file(1).toInt + 1
    var min_sup = config_file(2).toInt
    
    var trans_file = Source.fromFile("C:\Users\Iqra Malik\workspace\Assignment1/trans.txt" ).getLines.toList.map(f => f.split(",")).toArray.map(x => x.map(f=> f.toInt))
    
    var C1 = Array.fill(t_items)(0)
    var L1 = Array.fill(t_items)(0)
    println("First Candidate Set: \n")
    for(i <- 1 until t_items){
  	  var count = 0
  	  trans_file.map(s => s.map(t => if (t==i) count = count + 1 else t ))
  	  C1(i) = count
  	  println("Item#: " + i + "\t\t" + "Support:" + count)
    }
    
    println("Selected Item Set: \n")
    for(i <- 1 until t_items){
	  if (C1(i) >= min_sup){
	  	L1(i) = i
	  	println("Selected Item#: " + i + "\t\t" + "Support:" + C1(i))
	  }
  
  }
    
    
  }
}

