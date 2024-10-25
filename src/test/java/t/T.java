package t;

import org.testng.annotations.Test;
import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;

public class T {


    @Test
    public void t1() throws FileNotFoundException {
        System.out.println(dataModel().URL);
    }


    @Test
    public void t2() throws FileNotFoundException {
        System.out.println(dataModel().Login.ValidCredintails.Username);
        System.out.println(dataModel().Login.ValidCredintails.Password);

    }
    @Test
    public void t3() throws FileNotFoundException {
        System.out.println(dataModel().Login.InvalidCredintails.InvalidUsername.Username);
        System.out.println(dataModel().Login.InvalidCredintails.InvalidUsername.Password);
    }
    @Test
    public void t4() throws FileNotFoundException {
        System.out.println(dataModel().Login.InvalidCredintails.InvalidPassword.Username);
        System.out.println(dataModel().Login.InvalidCredintails.InvalidPassword.Password);
    }

}
