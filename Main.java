import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 0, 2,2));
        processes.add(new Process("P2", 2, 1, 1));
        processes.add(new Process("P3", 1, 8, 8));
        processes.add(new Process("P4", 5, 4, 4));
        processes.add(new Process("P5", 4, 5, 5));

        RoundRobinScheduler scheduler = new RoundRobinScheduler(processes, 8);
        scheduler.runScheduler();
    }
}

//public class Main {
//    public static void main(String[] args) {
//        List<Process> processes = new ArrayList<>();
//        processes.add(new Process("P1", 0, 2, 2));
//        processes.add(new Process("P2", 2, 1, 1));
//        processes.add(new Process("P3", 1, 8, 4));
//        processes.add(new Process("P4", 5, 4, 2));
//        processes.add(new Process("P5", 4, 5, 3));
//
//        PreemptivePriorityScheduler scheduler = new PreemptivePriorityScheduler(processes);
//        scheduler.schedule();
//    }
//}

