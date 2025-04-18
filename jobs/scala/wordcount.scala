import org.apache.spark.sql.SparkSession

object WordCount {
    def main(args: Array[String]) {
        val spark = SparkSession.builder
            .appName("Word Count")
            .getOrCreate()
        val sc = spark.sparkContext

        val textData = sc.parallelize(List("Hello world.", "Hello Spark.", "Hello Airflow."))

        val counts = textData.flatMap(line => line.split(" "))
            .map(word => (word, 1))
            .reduceByKey(_ + _)

        counts.collect().foreach(println)

        spark.stop()
        
    }
}