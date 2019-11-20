public class CleaningrobotBatteryChargingStatusCommand implements Command, Runnable{
    Cleaningrobot cleaningrobot;

    public CleaningrobotBatteryChargingStatusCommand(Cleaningrobot cleaningrobot){
        this.cleaningrobot = cleaningrobot;
    }

    public void execute(){
        cleaningrobot.checkBatteryChargingStatus();

    }

    @Override
    public void run() {
        execute();
    }
}