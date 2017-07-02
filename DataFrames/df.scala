import org.apache.Spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()
val df = Spark.read.csv("CitiGroup2006_2008")

df.head(5)
