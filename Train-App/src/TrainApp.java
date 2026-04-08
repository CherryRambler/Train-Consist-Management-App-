public class TrainApp {


    public static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    public static class PassengerBogie {
        private String type;   
        private int capacity;  


        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() {
            return type;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return type + " bogie with capacity " + capacity;
        }
    }


    public static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    public static class GoodsBogie {
        private String shape;   
        private String cargo;   

        public GoodsBogie(String shape) {
            this.shape = shape;
        }

        public void assignCargo(String cargo) {
            try {
                if ("Rectangular".equalsIgnoreCase(shape) && "Petroleum".equalsIgnoreCase(cargo)) {
                    throw new CargoSafetyException(
                        "Unsafe cargo assignment: Petroleum in Rectangular bogie!"
                    );
                }
                this.cargo = cargo;
                System.out.println("Cargo assigned successfully: " + cargo);
            } catch (CargoSafetyException e) {
                System.err.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Cargo assignment validation complete.\n");
            }
        }

        public String getCargo() {
            return cargo;
        }
    }


    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App Demo ===\n");

        System.out.println(">>> UC14: Passenger Bogie Creation with Capacity Validation");

        try {
            PassengerBogie bogie1 = new PassengerBogie("Sleeper", 50);
            System.out.println("Created: " + bogie1);

            PassengerBogie bogie2 = new PassengerBogie("AC Chair", 30);
            System.out.println("Created: " + bogie2);

            PassengerBogie bogie3 = new PassengerBogie("First Class", -10); 
            System.out.println("Created: " + bogie3);

        } catch (InvalidCapacityException e) {
            System.err.println("Error creating passenger bogie: " + e.getMessage());
        }

        try {
            PassengerBogie bogie4 = new PassengerBogie("Sleeper", 0); // Invalid
            System.out.println("Created: " + bogie4);
        } catch (InvalidCapacityException e) {
            System.err.println("Error creating passenger bogie: " + e.getMessage());
        }

        System.out.println("\n>>> UC15: Goods Bogie Cargo Assignment with Safety Validation");

        GoodsBogie gBogie1 = new GoodsBogie("Rectangular");
        GoodsBogie gBogie2 = new GoodsBogie("Cylindrical");
        GoodsBogie gBogie3 = new GoodsBogie("Rectangular");

        gBogie1.assignCargo("Petroleum");
        System.out.println("G-Bogie1 cargo: " + gBogie1.getCargo() + "\n");

        gBogie2.assignCargo("Petroleum");
        System.out.println("G-Bogie2 cargo: " + gBogie2.getCargo() + "\n");

        gBogie3.assignCargo("Coal");
        System.out.println("G-Bogie3 cargo: " + gBogie3.getCargo() + "\n");

        System.out.println("=== End of Demo ===");
    }
}
