import org.apache.spark.{SparkConf, SparkContext}

object wordcount {
  def main(args: Array[String]): Unit = {
    //本地模式的最简单一种
    val conf=new
      SparkConf().setMaster("local").setAppName("WordCount")
    val sc =new SparkContext(conf)

    val wordString=Array("hadoop", "hadoop", "spark", "spark", "spark", "spark", "flink", "flink", "flink", "flink",
      "flink", "flink", "hive", "flink", "hdfs", "yarn", "zookeeper", "hbase", "impala", "sqoop", "hadoop")
    //从本地文件创建
    //val lines: RDD[String]=sc.textFile("./wcinput/wc.txt")
    val lines=sc.parallelize(wordString)
    lines.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).collect().foreach(println)
    sc.stop();
  }
}
