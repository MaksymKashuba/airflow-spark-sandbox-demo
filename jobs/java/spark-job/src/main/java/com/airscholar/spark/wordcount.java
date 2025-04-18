package com.airscholar.spark;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import java.util.Arrays;
import java.util.List;
/**
 * Hello world!
 *
 */
public class wordcount 
{
    public static void main( String[] args )
    {
        SparkConf conf = new SparkConf().setAppName("WordCount").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

        String text = "Hallo World! Hello Spark!";
        List<String> lines = Arrays.asList(text.split(" "));

        JavaRdd<String> rdd = sc.parallelize(lines);
        JavaPairRDD<String, Integer> wordCounts = rdd.mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey((a, b) -> a + b);
        
        List<Tuple2<String, Integer>> output = wordCounts.collect();
        for (Tuple2<String, Integer> tuple : output) {
            System.out.println(tuple._1() + ": " + tuple._2());
        }
    }
}
