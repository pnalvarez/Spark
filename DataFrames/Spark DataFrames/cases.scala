case class Person(title: String, age: Long)
case class People(title: String, age: Long, neighborhood: String, grade: Double)

val person = Seq(Person("pedrinho",23),Person("zezinho",67),Person("menezes",22)).toDS()
person.show()

val primitive = Seq(1.0,2.0,3.0).toDS()
val arr = primitive.map(_/2).collect()

for(i <- arr){
  println(i)
}

val spark = SparkSession.builder().getOrCreate()
val df = spark.read.option("header","true").option("inferSchema","true").csv("People").as[People]
df.show()

val people = spark.sparkContext.textFile("People.txt").map(_.split(",")).map(attributes =>
People(attributes(0),attributes(1).trim.toInt,attributes(2),attributes(3).trim.toInt)).toDF
