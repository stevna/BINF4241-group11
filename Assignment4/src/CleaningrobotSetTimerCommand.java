public class CleaningrobotSetTimerCommand implements Command, Runnable {
    Cleaningrobot cleaningrobot;

    public CleaningrobotSetTimerCommand(Cleaningrobot cleaningrobot){
        this.cleaningrobot = cleaningrobot;
    }

    public void execute() {
        cleaningrobot.setTimer();
    }

    @Override
    public void run() {
        execute();
    }
}