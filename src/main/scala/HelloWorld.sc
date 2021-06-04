import java.io.{File, FileNotFoundException, FileReader, IOException}
import scala.io.StdIn.readLine

println("hello world")

def gcdLoop(x: Long, y: Long): Long = {
  var a = x
  var b = y
  while (a != 0) {
    val temp = a
    a = b % a
    b = temp
  }
  b
}

gcdLoop(12,44)

//def greet() = { println("Helllo") }
//
//() == greet()

for(i <- 1 to 4)
  println(s"Iteration $i")

for (i<-1 until 4)
  println(s"Iteration $i")

val filesHere = (new java.io.File(".")).listFiles

//for (file <- filesHere)
//  println(file)

//for (i <- 0 to filesHere.length - 1)
//  println(filesHere(i))

//for(file <- filesHere if file.getName.endsWith("scala"))
//  println(file)

//for (
//  file <- filesHere
////  if file.isFile
//  if file.getName.endsWith("java")
//) println(file)

def fileLines(file: java.io.File) =
  scala.io.Source.fromFile(file).getLines().toList

def grep(pattern: String) =
  for (
    file <- filesHere
    if file.getName.endsWith(".scala");
    line <- fileLines(file)
    if line.trim.matches(pattern)
  ) println(file + ": " + line.trim)

grep(".*gcd.*")

def oddNums(list: List[Int]) =
  for {
    num <- list
    if(num % 2 != 0)
  } yield num

val list = (1 to 10).toList
val res = oddNums(list)
println(res)

val n = 2
val half = if(n%2 == 0) n/2 else throw new RuntimeException("n must be even")
print(half)

val f = new FileReader("/home/dhrupal_108/Downloads/Valens ES Project/Scala training/DemoScala/Demo1/src/main/scala/hello.txt")
try {
  println(f.toString)
} catch {
  case ex: FileNotFoundException => println("File not found..")
  case ex: IOException => println("Io exception occuered")
} finally {
  f.close();
  println("File closed..")
}

def f():Int = try return 1 finally return 2
f()

def g(): Int = try 1 finally 2
g()

val firstArg = "bati"

firstArg match {
  case "salt" => println("pepper")
  case "chips" => println("salsa")
  case "eggs" => println("bacon")
  case _ => println("huh?")
}

def printMultiTable() = {

  var i = 1
  // only i in scope here

  while (i <= 10) {

    var j = 1
    // both i and j in scope here

    while (j <= 10) {

      val prod = (i * j).toString
      // i, j, and prod in scope here

      var k = prod.length
      // i, j, prod, and k in scope here

      while (k < 4) {
        print(".")
        k += 1
      }

      print(prod)
      j += 1
    }

    // i and j still in scope; prod and k out of scope

    println()
    i += 1
  }

  // i still in scope; j, prod, and k out of scope
}

printMultiTable()

def makeRowSeq(row: Int) =
  for(col <- 1 to 10) yield {
    val prod = (row * col).toString
    val padding = " " * (4 - prod.length)
    padding + prod
  }

def makeRow(row: Int) = makeRowSeq(row).mkString

def multiTable() = {
  val tableSeq =
    for(row <- 1 to 10)
      yield makeRow(row)

  tableSeq.mkString("\n")
}

multiTable()
