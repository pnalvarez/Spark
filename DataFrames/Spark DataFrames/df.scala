import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()
val df = spark.read.option("header","true").option("inferSchema","true").csv("CitiGroup2006_2008")
//df.head(5)

df.printSchema()

import spark.implicits._

df.filter($"High" === 484.40 ).show()
df.select(corr("High","Low")).show()

df.select("High","Low","Open").show()
df.groupBy("Open").count().show()

df.createGlobalTempView("view")

val sql = spark.sql("SELECT Date FROM global_temp.view ")

sql.show()
