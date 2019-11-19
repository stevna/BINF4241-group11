public class CleaningrobotStartVacuumCleanerCommand implements Command, Runnable {
    Cleaningrobot cleaningrobot;

    public CleaningrobotStartVacuumCleanerCommand(Cleaningrobot cleaningrobot){
        this.cleaningrobot = cleaningrobot;
    }

    public void execute() {
        cleaningrobot.startVacuumCleaner();
    }

    @Override
    public void run() {
        execute();
    }
}
