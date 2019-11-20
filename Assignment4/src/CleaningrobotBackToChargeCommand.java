public class CleaningrobotBackToChargeCommand implements Command {
    Cleaningrobot cleaningrobot;

    public CleaningrobotBackToChargeCommand(Cleaningrobot cleaningrobot) {
        this.cleaningrobot = cleaningrobot;

    }
    public void execute(){
        cleaningrobot.backToCharge();

    }

}
