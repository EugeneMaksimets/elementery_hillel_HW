package entity;

public class Worker {
    private double amount;
    private String name;
    private int countWorker;

    public Worker(double amount, String name, int countWorker) {
        this.amount = amount;
        this.name = name;
        this.countWorker = countWorker;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountWorker() {
        return countWorker;
    }

    public void setCountWorker(int countWorker) {
        this.countWorker = countWorker;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "amount=" + amount +
                ", name='" + name + '\'' +
                ", countWorker=" + countWorker +
                '}';
    }
}
