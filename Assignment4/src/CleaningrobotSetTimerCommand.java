public class CleaningrobotSetTimerCommand implements Command {
    Cleaningrobot cleaningrobot;

    public CleaningrobotSetTimerCommand(Cleaningrobot cleaningrobot){
        this.cleaningrobot = cleaningrobot;
    }

    public void execute() {
        cleaningrobot.setTimer();
    }

}