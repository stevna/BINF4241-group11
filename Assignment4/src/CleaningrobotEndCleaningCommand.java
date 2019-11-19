public class CleaningrobotEndCleaningCommand implements Command, Runnable {
    Cleaningrobot cleaningrobot;

    public CleaningrobotEndCleaningCommand(Cleaningrobot cleaningrobot){
        this.cleaningrobot = cleaningrobot;
    }

    public void execute() {
        cleaningrobot.endCleaning();
    }

    @Override
    public void run() {
        execute();
    }
}