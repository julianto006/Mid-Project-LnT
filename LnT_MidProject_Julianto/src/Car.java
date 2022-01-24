public class Car extends kendaraan{

    private int entertain;
    private String carType;

    public Car(String type, String brand, String name, String license, int topSpeed, int gasCapacity, int wheel, int entertain, String carType) {
        super(type, brand, name, license, topSpeed, gasCapacity, wheel);
        this.entertain = entertain;
        this.carType = carType;
    }

    public int getEntertain() {
        return entertain;
    }

    public void setEntertain(int entertain) {
        this.entertain = entertain;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
