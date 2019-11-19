public class CleaningrobotBackToChargeCommand implements Command, Runnable{
    Cleaningrobot cleaningrobot;

    public CleaningrobotBackToChargeCommand(Cleaningrobot cleaningrobot) {
        this.cleaningrobot = cleaningrobot;

    }
    public void execute(){
        cleaningrobot.backToCharge();

    }

    @Override
    public void run() {
        execute();
    }
}
