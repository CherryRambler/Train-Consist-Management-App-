import java.util.*;

class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    private String type;
    private String cargo;

    public GoodsBogie(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    public void assignCargo(String cargo) {
        try {
            if (type.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe Assignment: Rectangular bogie cannot carry Petroleum");
            }

            this.cargo = cargo;
            System.out.println("✅ Cargo assigned successfully: " + cargo);

        } catch (CargoSafetyException e) {
            System.out.println("❌ Error: " + e.getMessage());

        } finally {
            System.out.println("ℹ️ Cargo assignment attempt completed for bogie type: " + type);
        }
    }

    @Override
    public String toString() {
        return "Type: " + type + " | Cargo: " + (cargo == null ? "None" : cargo);
    }
}

public class TrainApp {

    public static void main(String[] args) {

        // Create bogies
        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");


        System.out.println("\nAssigning Petroleum to Cylindrical:");
        b1.assignCargo("Petroleum");


        System.out.println("\nAssigning Petroleum to Rectangular:");
        b2.assignCargo("Petroleum");

        System.out.println("\nAssigning Coal to Rectangular:");
        b2.assignCargo("Coal");


        System.out.println("\n--- Final Bogie Status ---");
        System.out.println(b1);
        System.out.println(b2);

        System.out.println("\nProgram continues safely after handling exceptions.");
    }
}