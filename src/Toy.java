public class Toy extends Thread{
    Switcher switcher;

    public Toy(Switcher switcher, String title) {
        this.switcher = switcher;
        this.setName(title);
        System.out.printf("%s увидел, что к игрушке подошли и напрягся\n", this.getName());
    }

    @Override
    public void run() {
        while (true) {
            if (switcher.state.get()) {
                System.out.printf("%s закрыл коробку!\n", this.getName());
                switcher.state.set(false);
            }
        }
    }
}