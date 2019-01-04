package sample;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

public class BMI_Calculator {

    @FXML
     ImageView lol;

    public double calculator ()
    {
        double height=Controller.height/100;
        return Controller.weight/ Math.pow(height,2);

    }

    public String checkResult ()
    {
        double result=calculator();
        String witch="";

        if(result>=18.5 && result<=24.9){
            result= Math.round(result);
           witch="Twoje BMI jest równe: "+result+". Masz prawidłową wagę.";
        }
        else if(result<18.5){
            result= Math.round(result);
            witch="Twoje BMI jest równe: "+result+". Masz niedowagę.";
        }
        else if (result>24.9) {
            result = Math.round(result);
            witch = "Twoje BMI jest równe: " + result + ". Masz nadwagę.";
        }

        return witch;
    }

}
