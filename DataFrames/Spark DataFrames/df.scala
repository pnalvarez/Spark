import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()
val df = spark.read.csv("CitiGroup2006_2008")
//df.head(5)

for(row <- df.head(5)){
  println(row)
}
