import com.techelevator.StuffedAnimals;
import org.junit.Assert;
import org.junit.Test;

public class StuffedAnimalsTest {
    @Test

    public void given_the_color_return_correct_color_code() {

        StuffedAnimals colorTest = new StuffedAnimals();

        Assert.assertEquals("\u001B[38;5;206m", StuffedAnimals.Pink);

    }

    @Test

    public void given_the_sound_return_correct_string() {
        StuffedAnimals soundTest = new StuffedAnimals();
        String animal = "Quack, Quack, Quackers!";

        Assert.assertEquals("Quack, Quack, Quackers!",animal);
    }



}
