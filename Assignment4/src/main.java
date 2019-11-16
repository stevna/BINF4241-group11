public class main {
    public static void main(String args[])
    {
        Remote remote = new Remote();
        Cleaningrobot cleaningrobot = new Cleaningrobot();

        CleaningrobotStartVacuumCleanerCommand start = new CleaningrobotStartVacuumCleanerCommand(cleaningrobot);

        CleaningrobotBackToChargeCommand backtocharge = new CleaningrobotBackToChargeCommand(cleaningrobot);

        remote.setCommand(start);
        remote.pressButton();

        remote.setCommand(backtocharge);
        remote.pressButton();
    }
}
