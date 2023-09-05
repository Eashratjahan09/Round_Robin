import java.util.*;

class RoundRobinScheduler {
    private List<Process> processes;
    private PriorityQueue<Process> readyQueue;
    private GlobalTimer timer;
    private int timeQuantum;


    public RoundRobinScheduler(List<Process> processes, int timeQuantum) {
        this.processes = processes;
        this.readyQueue = new PriorityQueue<>();
        this.timer = new GlobalTimer();
        this.timeQuantum = timeQuantum;

    }


    public void runScheduler() {
        while (!readyQueue.isEmpty() || !processes.isEmpty()){
            List<Process> arrivedProcesses = new ArrayList<>();
            for (Process process : processes) {
                if (process.getArrivalTime() <= timer.getTime()) {
                    arrivedProcesses.add(process);
                }
            }
            for (Process arrivedProcess : arrivedProcesses) {
                processes.remove(arrivedProcess);
                readyQueue.add(arrivedProcess);

            }
            //timer.incrementTime();
            while (!readyQueue.isEmpty()){

                Process currentProcess = readyQueue.poll();

                currentProcess.remainingTime=currentProcess.remainingTime-timeQuantum;
                System.out.println("Time: " + timer.getTime() + ", Running process: " + currentProcess.getName());
                timer.updateTime(timeQuantum);
                if(currentProcess.remainingTime<0){
                    System.out.println("Idle time till" + "Time:" + timer.getTime());
                    System.out.println("process finished");
                }else if(currentProcess.remainingTime>0){
                    System.out.println("Time: " + timer.getTime() + ", Running process: " + currentProcess.getName());
                    System.out.println("Time: " + timer.getTime()+currentProcess.remainingTime + ", Running process: " + currentProcess.getName());
                    readyQueue.add(currentProcess);
                }
                else{
                    System.out.println("process finished");
                }

            }



        }
        System.out.println("All processes have been executed.");

    }
}