import greed_algos.Job

val jobs = List(Job(3, 5), Job(1,2))
var current:Long = 0

jobs.map(job => {
  current += job.length
  Job(current, job.weight)
})