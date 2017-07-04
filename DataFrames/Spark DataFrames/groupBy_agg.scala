import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header","true").option("inferSchema","true").csv("Sales.csv")
df.printSchema()

//df.groupBy("Person").mean().show()
//df.groupBy("Company").max().show()
//df.groupBy("Company").min().show()
//df.groupBy("Company").sum().show()

df.select(sum("Sales")).show()
df.select(countDistinct("Sales")).show()
df.select(collect_set("Sales")).show()

df.orderBy("Person","Sales").show()
