package fcfs.scheduling.algorithm;
/*Calculates 
 * completionTime (Array of processes[arrival time] [burst time]) - Completion Time - Time taken for the execution to complete, starting from arrival time of first process.
 * turnAroundTime (Array of processes[arrival time] [burst time]) - Turn Around Time - Time taken to complete after arrival. In simple words, it is the difference between the Completion time and the Arrival time.
 * waitingTime (Array of processes[arrival time] [burst time]) - Waiting Time - Total time the process has to wait before it's execution begins. It is the difference between the Turn Around time and the Burst time of the process.
 * averageWaitingTime (Array of processes[arrival time] [burst time]) - Average waiting time of processes. 
 * maximumWaitingTime (Array of processes[arrival time] [burst time]) - Maximum waiting time period for a process in queue.
 */

class JobScheduler {

    public int[] completionTime(int[][] processes) {
        int numberOfProcesses = processes.length;
        int arrivalTimeIndex = 0;
        int burstTimeIndex = 1;
        int processTime = 0;
        int completionTimeOfTheProcesses[] = new int[numberOfProcesses];
        for (int i = 0; i < numberOfProcesses; i++) {
            if (i == 0) {
                processTime = processes[i][arrivalTimeIndex] + processes[i][burstTimeIndex];
                completionTimeOfTheProcesses[i] = processTime;
            } else if (processTime < processes[i][arrivalTimeIndex]) {
                processTime = processes[i][arrivalTimeIndex] + processes[i][burstTimeIndex];
                completionTimeOfTheProcesses[i] = processTime;
            } else {
                processTime = processTime + processes[i][burstTimeIndex];
                completionTimeOfTheProcesses[i] = processTime;
            }
        }

        return completionTimeOfTheProcesses;
    }

    public int[] turnAroundTime(int[][] processes) {
        int numberOfProcesses = processes.length;
        int arrivalTimeIndex = 0;
        int[] timeToComplete = completionTime(processes);
        int timeToCompleteAfterArrival[] = new int[numberOfProcesses];
        for (int i = 0; i < numberOfProcesses; i++) {
            timeToCompleteAfterArrival[i] = timeToComplete[i] - processes[i][arrivalTimeIndex];
        }
        return timeToCompleteAfterArrival;
    }

    public int[] waitingTime(int[][] processes) {
        int numberOfProcesses = processes.length;
        int burstTimeIndex = 1;
        int[] turnAround = turnAroundTime(processes);
        int timeProcessHasToWait[] = new int[numberOfProcesses];
        for (int i = 0; i < numberOfProcesses; i++) {
            timeProcessHasToWait[i] = turnAround[i] - processes[i][burstTimeIndex];
        }

        return timeProcessHasToWait;
    }

    public int averageWaitingTime(int[][] processes) {
        int numberOfProcesses = processes.length;
        int timeToWait[] = waitingTime(processes);
        int totalSumOfWaitingTime = 0;
        for (int i = 0; i < numberOfProcesses; i++) {
            totalSumOfWaitingTime = totalSumOfWaitingTime + timeToWait[i];
        }

        return totalSumOfWaitingTime / numberOfProcesses;

    }

    public int maximumWaitingTime(int[][] processes) {
        int numberOfProcesses = processes.length;
        int timeToWait[] = waitingTime(processes);
        int maxTimeToWait = 0;
        for (int i = 0; i < numberOfProcesses; i++) {
            if (maxTimeToWait < timeToWait[i]) {
                maxTimeToWait = timeToWait[i];
            }
        }

        return maxTimeToWait;

    }

}
