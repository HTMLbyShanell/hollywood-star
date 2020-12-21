/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hollywoodstarfx;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HollywoodStarFx extends Application {

    @Override

    public void start(Stage primaryStage) {

       

        //creating a star with radius=300

        Polygon star = createStar(300);
        Text text = new Text("SHANELL");

        //increasing font size

        text.setFont(new Font(20));

        //creating a stackpane, adding star and text

        StackPane root = new StackPane(star, text);

        //setting up and displaying a scene

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hollywood Star");
        primaryStage.show();

    }

   

    //method to create a polygon containing points for creating a star with given radius

    private Polygon createStar(double radius) {

        Polygon star = new Polygon();

        // starting angle in degrees

        double angle = -90;

        double x, y;

        // looping for 10 times (10 vertices)

        for (int i = 0; i < 10; i++) {

            // we are finding x, y coordinates of a point which is radius
            // distance away from center coordinates (0,0) at the given angle
            // here we use two radii, one for the outer vertices, and one for
            // the inner ones.

            if (i % 2 == 0) {

                // formula to find x coordinate: radius * cos(angle)

                x = (int) (radius * Math.cos(Math.toRadians(angle)));

                // formula to find y coordinate: radius * sin(angle)

                y = (int) (radius * Math.sin(Math.toRadians(angle)));

            } else {

                // similar to above, but using radius/2.5 as radius for the
                // inner vertices

                x = (int) ((radius / 2.5)

                        * Math.cos(Math.toRadians(angle)));

                y = (int) ((radius / 2.5)

                        * Math.sin(Math.toRadians(angle)));

            }

            //adding x,y to polygon

            star.getPoints().addAll(x, y);

            // moving to next angle (36=360 divided by 10 points)

            angle += 36;

        }

        //no fill color and black stroke color
        star.setFill(Color.YELLOW);
        star.setStroke(Color.BLACK);
        return star;

    }

    public static void main(String[] args) {

        launch(args);

    }

}