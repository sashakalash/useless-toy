public class Toy extends Thread{
    private Switcher switcher;

    public Toy(Switcher switcher, String title) {
        this.switcher = switcher;
        this.setName(title);
        System.out.printf("%s увидел, что к игрушке подошли и напрягся\n", this.getName());
    }

    @Override
    public void run() {
        while (true) {
            if (switcher.state) {
                System.out.printf("%s закрыл коробку!\n", this.getName());
                switcher.state = false;
            }
        }
    }
}