public class CleaningrobotEndCleaningCommand implements Command {
    Cleaningrobot cleaningrobot;

    public CleaningrobotEndCleaningCommand(Cleaningrobot cleaningrobot){
        this.cleaningrobot = cleaningrobot;
    }

    public void execute() {
        cleaningrobot.endCleaning();
    }

}