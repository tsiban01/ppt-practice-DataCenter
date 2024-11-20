package datacenter;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Processor {

    /*
        Abstraction Function:
            this represents a processor with time capacity this.timeLimit
            and holds the jobs in this.jobs
        Representation Invariant:
            jobs != null && jobs does not contain nulls
            && timeLimit > 0
            && total computation time of jobs does not exceed timeLimit
     */

    private List<Job> jobs;
    private int timeLimit;

    /**
     * Create a new empty processor
     * @param timeLimit the limit on compute time on this processor, > 0
     */
    public Processor(int timeLimit) {
        if (timeLimit <= 0) {
            throw new IllegalArgumentException("Time limit must be positive.");
        }
        this.timeLimit = timeLimit;
        this.jobs = new ArrayList<>();
    }

    /**
     * Check if a given job can fit in this processor
     *
     * @return true if adding the job does not exceed the time limit on this processor, and false otherwise.
     */
    public boolean canFitJob(Job job) {
        if (job == null) {
            throw new IllegalArgumentException("Job cannot be null.");
        }
        return getTotalComputationTime() + job.getExecutionTime() <= timeLimit;
    }

    /** Inserts a job to the processor, at the end of its schedule
     *
     * @param job not null
     * @return true if the job can fit on this processor and was assigned, and false otherwise
     */
    public boolean addJob(Job job) {
        if (canFitJob(job)) {
            jobs.add(job);
            return true;
        }
        return false;
    }

    /** Get the peak memory usage of this processor
     *
     * @return the peak memory usage of the jobs assigned to this processor
     */
    public int getPeakMemoryUsage() {
        int peakMemory = 0;
        for (Job job : jobs) {
            peakMemory = Math.max(peakMemory, job.getMemoryRequirement());
        }
        return peakMemory;
    }

    /** Get the total computation (execution) time of this processor
     *
     * @return the total computation (execution) time of jobs assigned
     * to this processor
     */
    public int getTotalComputationTime() {
        int totalTime = 0;
        for (Job job : jobs) {
            totalTime += job.getExecutionTime();
        }
        return totalTime;
    }

    /** Check if this processor is equal to a given processor
     *
     * @return true if both processors have exactly the same jobs,
     * in the same order, and they have the same time limit
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Processor other = (Processor) obj;
        return this.timeLimit == other.timeLimit && this.jobs.equals(other.jobs);
    }

    /** Get the time limit of this processor
     *
     * @return the time limit on this processor
     */
    public int getTimeLimit() {
        return this.timeLimit;
    }

    /**
     * Obtain the jobs scheduled on this processor, in scheduled order
     * @return the jobs scheduled on this processor, in scheduled order
     */
    public Job[] getJobs() {
        return jobs.toArray(new Job[0]);
    }

    /**
     * Check Representation Invariant
     */
    private void checkRep() {
        assert jobs != null : "Jobs list cannot be null.";
        assert timeLimit > 0 : "Time limit must be positive.";
        int totalComputationTime = 0;
        for (Job job : jobs) {
            assert job != null : "Job in jobs list cannot be null.";
            totalComputationTime += job.getExecutionTime();
        }
        assert totalComputationTime <= timeLimit : "Total computation time exceeds time limit.";
    }
}
