package fcfs.scheduling.algorithm;

class Main {

    public static void main(String[] args) {

        JobScheduler jobs = new JobScheduler();

        // Two dimensional array of Processes with their {arrival time in
        // seconds,burst time in seconds}
        int[][] processes = { { 0, 10 }, { 6, 20 }, { 60, 10 }, { 110, 5 } };

        int[] timeOfCompletion = jobs.completionTime(processes);
        int[] timeOfWaiting = jobs.waitingTime(processes);
        int[] timeOfTurnAround = jobs.turnAroundTime(processes);

        for (int i = 0; i < processes.length; i++) {
            System.out.println("Process number " + i);
            System.out.println("Completion time " + timeOfCompletion[i]);
            System.out.println("Waiting time " + timeOfWaiting[i]);
            System.out.println("Turn Around Time " + timeOfTurnAround[i]);
        }

        System.out.println("Average waiting time " + jobs.averageWaitingTime(processes));
        System.out.println("Max waiting time " + jobs.maximumWaitingTime(processes));

    }

}
