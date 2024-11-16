package datacenter;

import java.util.ArrayList;
import java.util.List;

public class Placement {
    private List<Processor> processors;

    /** Create a new empty placement
     *
     */
    public Placement() {
        this.processors = new ArrayList<Processor>();
    }

    /** Add a processor to this placement
     *
     */
    public void addProcessor(Processor processor) {
        this.processors.add(processor);
    }

    /** Get the cost of this placement
     *
     *  @return cost
     */
    public int getCost() {
        // TODO: Implement this
        return -1;
    }

    /**
     * Compute the makespan of this placement
     *
     * @return the makespan of the placement, and return 0, if there is no work
     * (no processors or no jobs on any processor)
     */
    public int getMakeSpan() {
        // TODO: Implement this
        return -1;
    }

    /** Check if this placement is equal to another given placement
     *
     * @param that is the other placement to check
     * @return true if (1) number of processors in "that" is
     * equal to the number of processors in "this", and (2) each processor
     * in "this" is equal to the corresponding processor in "that"
     * (order of processors does matter)
     * */
    public boolean equals(Placement that) {
        // TODO: Implement this
        return false;
    }

    /** Obtain the mean flow time for this placement
     *
     * @return the mean flow time, and return 0 if there is no work (no processors or no jobs on any processor)
     */
    public double getMeanFlowTime() {
        // TODO: Implement this method
        return -1;
    }

    /** Obtain the median flow time for this placement
     *
     * @return the median flow time, and return 0 if there is no work (no processors or no jobs on any processors)
     */
    public double getMedianFlowTime() {
        // TODO: Implement this method
        return -1;
    }

}