public class CleaningrobotBatteryChargingStatusCommand implements Command {
    Cleaningrobot cleaningrobot;

    public CleaningrobotBatteryChargingStatusCommand(Cleaningrobot cleaningrobot){
        this.cleaningrobot = cleaningrobot;
    }

    public void execute(){
        cleaningrobot.checkBatteryChargingStatus();

    }

}