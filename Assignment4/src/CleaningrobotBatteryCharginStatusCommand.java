public class CleaningrobotBatteryCharginStatusCommand implements Command{
    Cleaningrobot cleaningrobot;

    public CleaningrobotBatteryCharginStatusCommand(Cleaningrobot cleaningrobot){
        this.cleaningrobot = cleaningrobot;
    }

    public void execute(){
        cleaningrobot.checkBatteryChargingStatus();

    }

        }