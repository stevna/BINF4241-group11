public class CleaningrobotCheckCleaningPercentageCommand implements Command, Runnable {
    Cleaningrobot cleaningrobot;

    public CleaningrobotCheckCleaningPercentageCommand(Cleaningrobot cleaningrobot){
        this.cleaningrobot = cleaningrobot;
    }

    public void execute() {
        cleaningrobot.getCleaningPercentage();
    }

    @Override
    public void run() {
        execute();
    }
}