public class Motorcycle extends kendaraan{
    private int helm;
    private String motorType;

    public int getHelm() {
        return helm;
    }

    public void setHelm(int helm) {
        this.helm = helm;
    }

    public String getMotorType() {
        return motorType;
    }

    public void setMotorType(String motorType) {
        motorType = motorType;
    }

    public Motorcycle(String type, String brand, String name, String license, int topSpeed, int gasCapacity, int wheel, int helm, String motorType) {
        super(type, brand, name, license, topSpeed, gasCapacity, wheel);
        this.helm = helm;
        this.motorType = motorType;
    }
}
