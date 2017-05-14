package greed_algos

import scala.io.Source

object JobSchedulerDemo {

  type Lines = List[String]
  def main(args:Array[String]): Unit = {
    val lines = readLinesFromFile("jobs.txt")
    val jobs = lines.drop(1).map(line => {
      val parts = line.split("\\s")
      new Job(parts(0), parts(1))
    })

    val scheduler = new JobScheduler


    val (sum, list) = scheduler.schedule(jobs)
    println(sum)


//    println(lines.mkString("\n"))
  }

  def readLinesFromFile(fileName:String):Lines = {
    Source.fromResource(fileName).getLines().toList
  }


}
