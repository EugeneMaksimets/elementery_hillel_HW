public class Main {

    public static void main(String[] args) {
        Keyboard keyboard = new Keyboard();
        Monitor monitor = new Monitor();
        SystemUnit systemUnit = new SystemUnit();
        keyboard.setKeyboard("new keyboard");
        monitor.setMonitor("new monitor");
        systemUnit.setSystemUnit("new system unit");
        Computer computer = new Computer(keyboard.getKeyboard(), monitor.getMonitor(), systemUnit.getSystemUnit());
        System.out.println(computer);
    }
}