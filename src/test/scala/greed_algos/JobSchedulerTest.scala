package greed_algos

import org.scalatest.{BeforeAndAfter, FlatSpec, FunSuite, Matchers}

class JobSchedulerTest extends FlatSpec with BeforeAndAfter with Matchers {
  var scheduler: JobScheduler = _


  before {
    scheduler = new JobScheduler
  }

  it should "schedule two jobs correctly by using subtraction" in {
    val jobs = List(Job(3, 5), Job(1,2))

    scheduler.schedule(jobs) shouldBe ((23, List(Job(1,2), Job(3, 5))))
  }

  it should "schedule two jobs with equls subtraction result by higher weight" in {
    val jobs = List(Job(3, 5), Job(1,2), Job(5, 7))

    scheduler.schedule(jobs) shouldBe ((89, List(Job(1,2), Job(5,7), Job(3, 5))))
  }

}
