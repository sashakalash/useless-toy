public class User extends Thread {
    Switcher switcher;
    private final int USER_ACTION_FREQUENCY = 3000;
    private int proccessingCounter;

    public User(Switcher switcher, String title, int proccessingCounter) {
        this.switcher = switcher;
        this.proccessingCounter = proccessingCounter;
        this.setName(title);
        System.out.printf("%s подошел к игрушке\n", this.getName());
    }

    @Override
    public void run () {
        while (proccessingCounter > 0) {
            try {
                Thread.sleep(USER_ACTION_FREQUENCY);
                switcher.state.set(true);
                System.out.printf("%s открыл коробку!\n", this.getName());
                proccessingCounter--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%s передумал играть с коробкой!\n", this.getName());
    }
}