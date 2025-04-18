from pyspark.sql import SparkSession

spark = SparkSession.builder \
    .appName("PythonWordCountJob") \
    .getOrCreate()

text = "Hello world. Hello Spark. Hello Airflow."

words = spark.sparkContext.parallelize(text.split(" "))
word_counts = words.map(lambda word: (word, 1)).reduceByKey(lambda a, b: a + b)

for wc in word_counts.collect():
    print(wc[0], wc[1])

spark.stop()