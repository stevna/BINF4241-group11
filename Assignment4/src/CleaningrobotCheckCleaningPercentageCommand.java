public class CleaningrobotCheckCleaningPercentageCommand implements Command {
    Cleaningrobot cleaningrobot;

    public CleaningrobotCheckCleaningPercentageCommand(Cleaningrobot cleaningrobot){
        this.cleaningrobot = cleaningrobot;
    }

    public void execute() {
        cleaningrobot.getCleaningPercentage();
    }
}