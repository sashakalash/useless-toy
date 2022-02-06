public class Main {
    private static final int USER_ITERATION_COUNT = 10;

    public static void main(String[] args) throws InterruptedException {
        Switcher switcher = new Switcher();
        User user = new User(switcher, "Пользователь", USER_ITERATION_COUNT);
        Toy toy = new Toy(switcher, "Игрушка");

        user.start();
        toy.start();

        user.join();
        toy.interrupt();
    }
}