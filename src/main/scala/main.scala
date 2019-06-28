import org.apache.spark.sql.SparkSession


object Hello extends App {
  println("Hello, World!")

  override def main(args: Array[String]): Unit = {
    var spark = SparkSession.builder()
      .master("local[*]")
      //.appName("Spark_Guide")
      //.config("spark.some.config.option", "some-value")
      .getOrCreate()

    val file_path = getClass.getResource("/data/2015-summary.json").getPath
    val df = spark.read.json(file_path)
    df.show()

    //  todo  spark 로컬 shell에서 실행 하는 방법은 없는 건가 ??
  }
}
