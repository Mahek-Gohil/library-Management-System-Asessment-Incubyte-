import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryMangementSystemTest {

     private LibraryMangementSystem library;
    @BeforeEach
    public void setupLibrary(){
        library = new LibraryMangementSystem();
    }
    @Test
    public void testcheck(){
        System.out.println("Test Module Running");
    }

}
