public class CleaningrobotBatteryStatusCommand implements Command {
    Cleaningrobot cleaningrobot;

    public CleaningrobotBatteryStatusCommand(Cleaningrobot cleaningrobot){
        this.cleaningrobot = cleaningrobot;
    }

    public void execute() {
        cleaningrobot.checkBatteryStatus();
    }
}