import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    Scanner sc = new Scanner(System.in);
    Vector<kendaraan> vector = new Vector<>();
    public Main() {
        listInput();
    }

    public void listInput(){
        int pilihan;
        do{
            System.out.println("~~~Menu~~~");
            System.out.println("1. Input");
            System.out.println("2. View");
            System.out.printf("Choose: ");
            pilihan = sc.nextInt();
            switch (pilihan){
                case 1:
                    Input();
                case 2:
                    View();
            }
        } while (pilihan < 1 || pilihan > 2);

    }

    public void Input(){
        String type;
        String brand;
        String name;
        String license;
        int topSpeed = 0;
        int gasCapacity;
        int wheel;
        int entertain;
        int helm;
        String carType;
        String motorType;

        try {


            do {
                System.out.printf("Input type [Car | Motorcycle]: ");
                type = sc.next();
            } while (!(type.equals("Car") || type.equals("Motorcycle")));

            do {
                System.out.printf("Input Brand[>=5]: ");
                brand = sc.next();
            } while (brand.length() < 5);

            do {
                System.out.printf("Input Name[>=5]: ");
                name = sc.next();
            } while (name.length() < 5);

            String pattern = "([A-Z]+[A-Z]+)\\s\\d\\d\\d\\d\\s([A-Z]+[A-Z]+[A-Z])"; //String pattern = "BB 1928 WIB";

            boolean hasil;
            do {
                System.out.printf("Input License: ");
                license = sc.nextLine();

                Pattern pt = Pattern.compile(pattern);
                Matcher mt = pt.matcher(license);

                hasil = mt.matches();
            } while (hasil == false);

            do {
                System.out.printf("Input top speed [100 <= topSpeed <= 250]: ");
                topSpeed = sc.nextInt();
            } while (topSpeed < 100 || topSpeed > 250);

            do {
                System.out.printf("Input gas capacity [30 <= gasCap <= 60]: ");
                gasCapacity = sc.nextInt();
            } while (gasCapacity < 30 || gasCapacity > 60);

            if (type.equals("Car")) {
                do {
                    System.out.printf("Input wheel [ >=4 | <= 6]: ");
                    wheel = sc.nextInt();
                } while (wheel < 4 || wheel > 6);

                do {
                    System.out.printf("Input type [SUV | Supercar |Minivan]: ");
                    carType = sc.next();
                } while (!(carType.equals("SUV") || carType.equals("Supercar") || carType.equals("Minivan")));

                do {
                    System.out.printf("Input entertainment system amount [>= 1]: ");
                    entertain = sc.nextInt();
                } while (entertain < 1);
                vector.add(new Car(type, brand, name, license, topSpeed, gasCapacity, wheel, entertain, carType));
            } else  {
                do {
                    System.out.printf("Input wheel [ >=2 | <= 3]: ");
                    wheel = sc.nextInt();
                } while (wheel < 2 || wheel > 3);

                do {
                    System.out.printf("Input type [Automatic | Manual]: ");
                    motorType = sc.next();
                } while (!motorType.equals("Automatic") && !motorType.equals("Manual"));

                do {
                    System.out.printf("Input helm amount [>=1]: ");
                    helm = sc.nextInt();
                } while (helm < 1);
                vector.add(new Motorcycle(type, brand, name, license, topSpeed, gasCapacity, wheel, helm, motorType));
            }

            System.out.println("Enter to return...");
            sc.nextLine();
            listInput();

        } catch (Exception e){
            System.out.println("Inputan salah! Terminated~");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

    }

    public void View(){
        int pick;
        int priceHelm;
        int index;
        kendaraan kendaranGet = null;
        if(vector.isEmpty()) {
            System.out.println("Tidak Ada kendaraan!");
            System.out.println("~~~~~~~~~~~~~~~~~~~~");
        }else {
            for(int i = 0 ; i < vector.size(); i++) {
                kendaranGet = vector.get(i);

                System.out.println("No " + (i + 1));
                System.out.println("Name " + kendaranGet.getName());
                System.out.println("Type " + kendaranGet.getType());
            }
                System.out.printf("Pick a vehicle number to test drive[Enter '0' to exit]: ");
                pick = sc.nextInt();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        
                kendaranGet = vector.get(--pick);

                if(kendaranGet instanceof Car) {
                        Car carTipe = (Car) kendaranGet;
                        System.out.println("Brand: "+ carTipe.getBrand());
                        System.out.println("Name: "+ carTipe.getName());
                        System.out.println("Lisence Plate: "+ carTipe.getLicense());
                        System.out.println("Type: "+ carTipe.getCarType());
                        System.out.println("Gas Capacity: "+ carTipe.getGasCapacity());
                        System.out.println("Top Speed: "+ carTipe.getTopSpeed());
                        System.out.println("Wheel(s): "+ carTipe.getWheel());
                        System.out.println("Entertainment System: "+ carTipe.getEntertain());
                        System.out.println("Turning on entertainment system...");

                        //Hanya supercar yang dapat output boosting
                        if (carTipe.getCarType().equals("Supercar")){
                            System.out.println("Boosting!");
                            System.out.println("~~~~~~~~~");
                        }

                    } else {
                        Motorcycle motorTipe = (Motorcycle) kendaranGet;
                        System.out.println("Brand: "+ motorTipe.getBrand());
                        System.out.println("Name: " + motorTipe.getName());
                        System.out.println("Lisence Plate: " + motorTipe.getLicense());
                        System.out.println("Type: "+ motorTipe.getMotorType());
                        System.out.println("Gas Capacity: "+ motorTipe.getGasCapacity());
                        System.out.println("Top Speed: "+ motorTipe.getTopSpeed());
                        System.out.println("Wheel(s): "+ motorTipe.getWheel());
                        System.out.println( motorTipe.getName()+" is standing!");

                        System.out.printf("Input Helm Price: ");
                        priceHelm = sc.nextInt();
                        System.out.println("Price: "+priceHelm);

                    }
               if (pick == 0){
                     System.out.printf("Good bye!");
               }




        }

    }

    public static void main(String[] args) {
        new Main();
    }

}
