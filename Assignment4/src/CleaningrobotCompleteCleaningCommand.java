public class CleaningrobotCompleteCleaningCommand implements Command, Runnable {
    Cleaningrobot cleaningrobot;

    public CleaningrobotCompleteCleaningCommand(Cleaningrobot cleaningrobot){
        this.cleaningrobot = cleaningrobot;
    }

    public void execute() {
        cleaningrobot.completeCleaning();
    }

    @Override
    public void run() {
        execute();
    }
}