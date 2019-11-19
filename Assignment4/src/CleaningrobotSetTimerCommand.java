public class CleaningrobotSetTimerCommand implements Command, Runnable {
    Cleaningrobot cleaningrobot;
    int time;

    public CleaningrobotSetTimerCommand(Cleaningrobot cleaningrobot, int t){
        this.cleaningrobot = cleaningrobot;
        time = t;
    }

    public void execute() {
        cleaningrobot.setTimer(time);
    }

    @Override
    public void run() {
        execute();
    }
}