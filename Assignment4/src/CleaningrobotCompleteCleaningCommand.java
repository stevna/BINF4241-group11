public class CleaningrobotCompleteCleaningCommand implements Command {
    Cleaningrobot cleaningrobot;

    public CleaningrobotCompleteCleaningCommand(Cleaningrobot cleaningrobot){
        this.cleaningrobot = cleaningrobot;
    }

    public void execute() {
        cleaningrobot.completeCleaning();
    }

}