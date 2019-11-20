public class CleaningrobotBatteryStatusCommand implements Command, Runnable {
    Cleaningrobot cleaningrobot;

    public CleaningrobotBatteryStatusCommand(Cleaningrobot cleaningrobot){
        this.cleaningrobot = cleaningrobot;
    }

    public void execute() {
        cleaningrobot.checkBatteryStatus();
    }

    @Override
    public void run() {
        execute();
    }
}