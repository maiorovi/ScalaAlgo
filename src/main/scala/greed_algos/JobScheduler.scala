package greed_algos

class JobScheduler {

  def schedule(jobs: List[Job]): (Long, List[Job]) = {

    val sortedJobs = jobs.sortWith(jobOrderingFun)
    var current: Long = 0

    val jobsWithTimeToComplete: List[Job] = sortedJobs.map(job => {
      current += job.length
      Job(current, job.weight)
    })

    val minimizedValue = jobsWithTimeToComplete.foldLeft(0: Long)((acc, job) => (job.weight * job.length) + acc)

    (minimizedValue, sortedJobs)
  }

  def jobOrderingFun(j1: Job, j2: Job): Boolean = {
    val fstDiff = j1.weight - j1.length
    val sndDiff = j2.weight - j2.length

    if (fstDiff == sndDiff) {
      j1.weight > j2.weight
    } else {
      fstDiff - sndDiff > 0
    }
  }

}
