public class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}
public class GoodsBogie {
    private String shape;   
    private String cargo;   

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    public void assignCargo(String cargo) {
        try {
            if ("Rectangular".equalsIgnoreCase(shape) && "Petroleum".equalsIgnoreCase(cargo)) {
                throw new CargoSafetyException("Unsafe cargo assignment: Petroleum in Rectangular bogie!");
            }
            this.cargo = cargo;
            System.out.println("Cargo assigned successfully: " + cargo);
        } catch (CargoSafetyException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Cargo assignment validation complete.");
        }
    }

    public String getCargo() {
        return cargo;
    }
}
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GoodsBogieTest {

    @Test
    public void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical");
        bogie.assignCargo("Petroleum");
        assertEquals("Petroleum", bogie.getCargo());
    }

    @Test
    public void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");
        assertNull(bogie.getCargo());
    }

    @Test
    public void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");
        assertNull(bogie.getCargo(), "Cargo should not be assigned for unsafe combination.");
    }

    @Test
    public void testCargo_ProgramContinuesAfterException() {
        GoodsBogie bogie1 = new GoodsBogie("Rectangular");
        GoodsBogie bogie2 = new GoodsBogie("Cylindrical");

        bogie1.assignCargo("Petroleum"); 
        bogie2.assignCargo("Petroleum"); 

        assertNull(bogie1.getCargo(), "Rectangular bogie should not have petroleum.");
        assertEquals("Petroleum", bogie2.getCargo(), "Cylindrical bogie should have petroleum.");
    }

    @Test
    public void testCargo_FinallyBlockExecution() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");
        assertTrue(true); 
    }
}
