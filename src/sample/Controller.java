package sample;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import com.gluonhq.charm.glisten.control.TextField;
import java.io.File;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller   {

    @FXML
    Button submitButton;

    @FXML
    GridPane panel;

    @FXML
     TextField weightTF;

    @FXML
     TextField heightTF;

    @FXML
    Label weightLabel;

    @FXML
     Label heightLabel;

    @FXML
     Label resoult;

    @FXML
    ImageView lol;




    public static double weight;
    public static double height;

    public double x,y;

    @FXML
    public void buttonPA (ActionEvent event)
    {
        submitButton.setOnAction(value ->  {{

                convertText();
                BMI_Calculator calc = new BMI_Calculator();
                resoult.setText(calc.checkResult());
                setIcon();

        }

        });

    }

    @FXML
  public  void draggedP(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource())
                .getScene().getWindow();
        stage.setX(event.getScreenX()  - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
  public  void pressedP(MouseEvent event)
    {
        x=event.getSceneX();
        y=event.getSceneY();
    }

    public void setIcon()
    {
        try{

        BMI_Calculator calc= new BMI_Calculator();
        double result2=calc.calculator();

        if (result2 >= 18.5 && result2 <= 24.9) {
            System.out.println(result2);
            File file = new File("C:/Users/ilowe/IdeaProjects/BMI_Modern/prawidlowa.png");
            String localUrl = file.toURI().toURL().toString();
            Image img= new Image(localUrl);
            System.out.println("Image loaded? " + !img.isError());
            lol.setImage(img);

        } else if (result2 < 18.5) {
            File file = new File("C:/Users/ilowe/IdeaProjects/BMI_Modern/niedowaga.png");
            String localUrl = file.toURI().toURL().toString();
            Image img = new Image(localUrl);
            lol.setImage(img);

        } else if (result2 > 24.9) {
            File file = new File("C:/Users/ilowe/IdeaProjects/BMI_Modern/nadwaga.png");
            String localUrl = file.toURI().toURL().toString();
            Image img = new Image(localUrl);
            lol.setImage(img);
        }}
        catch(Exception ex)
        {}
    }

    public void convertText()
    {
        weight=Integer.parseInt(weightTF.getText());
        height=Integer.parseInt(heightTF.getText());

    }
}
