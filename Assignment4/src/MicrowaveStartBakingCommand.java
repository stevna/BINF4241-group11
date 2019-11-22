public class MicrowaveStartBakingCommand implements Command, Runnable{
    Microwave microwave;

    public MicrowaveStartBakingCommand(Microwave microwave) {
        this.microwave = microwave;

    }
    public void execute() {
        microwave.startBaking();

    }

    @Override
    public void run() {
        execute();
    }
}
