public class TrainApp {

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
        System.out.println("=== Train Consist Management App: UC15 Demo ===\n");

        GoodsBogie bogie1 = new GoodsBogie("Rectangular");
        GoodsBogie bogie2 = new GoodsBogie("Cylindrical");

        bogie1.assignCargo("Petroleum");
        System.out.println("Bogie1 cargo: " + bogie1.getCargo() + "\n");

        bogie2.assignCargo("Petroleum");
        System.out.println("Bogie2 cargo: " + bogie2.getCargo() + "\n");

        GoodsBogie bogie3 = new GoodsBogie("Rectangular");
        bogie3.assignCargo("Coal"); 
        System.out.println("Bogie3 cargo: " + bogie3.getCargo() + "\n");

        System.out.println("=== End of UC15 Demo ===");
    }
}
