import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header","true").option("inferSchema","true").csv("ContainsNull.csv")

df.show()
df.na.drop(2).show()
df.na.fill($"avg(Sales)",Array("Sales")).show()
