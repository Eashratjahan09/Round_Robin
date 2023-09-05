class Process implements Comparable<Process> {
    private String name;
    private int arrivalTime;
    private int burstTime;
    public int remainingTime;

    public Process(String name, int arrivalTime, int burstTime, int remainingTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime=burstTime;
    }

    public String getName() {
        return name;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void reduceBurstTime(int time) {
        burstTime -= time;
    }

    public boolean isFinished() {
        return burstTime <= 0;
    }
    public int compareTo(Process other) {
        return Integer.compare(this.arrivalTime, other.arrivalTime);
    }

}