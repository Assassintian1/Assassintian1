import org.apache.spark.{SparkConf, SparkContext}

object SimpleApp {
  def main(args: Array[String]): Unit = {
    val logFile="YOUR_SPARK_HOME/README.md"
    val conf=new
        SparkConf().setMaster("local").setAppName("WordCount")
    val sc =new SparkContext(conf)
    val logData=sc.parallelize(logFile).cache()
//    logData.filter(line =>line.contai)

  }
}
