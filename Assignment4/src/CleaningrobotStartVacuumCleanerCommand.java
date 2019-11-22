public class CleaningrobotStartVacuumCleanerCommand implements Command {
    Cleaningrobot cleaningrobot;

    public CleaningrobotStartVacuumCleanerCommand(Cleaningrobot cleaningrobot){
        this.cleaningrobot = cleaningrobot;
    }

    public void execute() {
        cleaningrobot.startVacuumCleaner();
    }

}
