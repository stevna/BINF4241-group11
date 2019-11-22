public class DishwasherCheckTimerCommand implements Command {

        private Dishwasher dishwasher;

        public DishwasherCheckTimerCommand(Dishwasher dishwasher) {
            this.dishwasher = dishwasher;

        }
        public void execute(){
            dishwasher.checkTimer();

        }
    }

