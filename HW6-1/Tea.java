package HW6;

class Tea extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Steeping tea bag");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding lemon");
    }
}
