import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.stage.WindowEvent;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Timer;
import java.util.TimerTask;

public class isTouch extends Application{
    private double circle1X = 0;
    private double circle1Y = 0;
    private double circle2X = 0;
    private double circle2Y = 0;
   /* double oldX1Pos = 1;
    double oldX2Pos = 1;
    double oldY1Pos = 4;
    double oldY2Pos = 1;*/

    private Circle circle1;
    private Circle circle2;
    private SVGPath svgPath;
    @Override
    public void start(Stage primaryStage) {
        IosToggleButton iosToggleButton = new IosToggleButton(90,false,7);
        iosToggleButton.setTranslateX(50);
        iosToggleButton.setTranslateY(50);

        var ref = new Object() {
            double speed = 0;
        };
        Slider slider = new Slider();
        primaryStage.setOnHiding((WindowEvent e) -> System.exit(50));
        Button button = new Button();
        svgPath = new SVGPath();
        svgPath.setContent("M15,30C6.7,30,0,23.3,0,15C0,8.4,5.4,3,12,3c4.8,0,8.7,3.5,9.5,8c0.5,3.1-0.9,6.2-3.5,8\n" +
                "\tc-4.4,2.9-9,0.6-10-3.3c-0.6-2.4,0.6-4.9,2.8-6c2.7-1.3,5.3,0.3,5.8,2.7c0.3,1.3-0.4,2.7-1.5,3.4c-2,1.2-4.1-0.2-4.1-2\n" +
                "\tc0-1.1,0.9-2,2-2 M15,15c0-1.8-0.9-3.2-2-3.2 M15,0c8.3,0,15,6.7,15,15c0,6.6-5.4,12-12,12c-4.8,0-8.7-3.5-9.5-8\n" +
                "\tC8,15.9,9.4,12.8,12,11c4.4-2.9,9-0.6,10,3.3c0.6,2.4-0.6,4.9-2.8,6c-2.7,1.3-5.3-0.3-5.8-2.7c-0.3-1.3,0.4-2.7,1.5-3.4\n" +
                "\tc2-1.2,4.1,0.2,4.1,2c0,1.1-0.9,2-2,2 M15,15c0,1.8,0.9,3.2,2,3.2 M30,15c0,8.3-6.7,15-15,15C8.4,30,3,24.6,3,18\n" +
                "\tc0-5.3,4.3-9.6,9.6-9.6c4.2,0,7.7,3.4,7.7,7.7c0,3.4-2.8,6.1-6.1,6.1c-2.7,0-4.9-2.2-4.9-4.9c0-2.2,1.8-3.9,3.9-3.9\n" +
                "\tc1.7,0,3.1,1.4,3.1,3.1c0,1.4-1.1,2.5-2.5,2.5c-1.1,0-2-0.9-2-2 M15,15c-1.8,0-3.2,0.9-3.2,2 M0,15C0,6.7,6.7,0,15,0\n" +
                "\tc6.6,0,12,5.4,12,12c0,5.3-4.3,9.6-9.6,9.6c-4.2,0-7.7-3.4-7.7-7.7c0-3.4,2.8-6.1,6.1-6.1c2.7,0,4.9,2.2,4.9,4.9\n" +
                "\tc0,2.2-1.8,3.9-3.9,3.9c-1.7,0-3.1-1.4-3.1-3.1c0-1.4,1.1-2.5,2.5-2.5c1.1,0,2,0.9,2,2 M15,15c1.8,0,3.2-0.9,3.2-2");
        circle1 = new Circle(1,4, 10);
        circle2 = new Circle(1, 20, 10);
        slider.setMinorTickCount(5);
        slider.setMajorTickUnit(25);
        slider.setBlockIncrement(0);
        slider.setMax(100);
        slider.setMin(0);
        slider.setTranslateX(100);
        slider.setTranslateY(200);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setSnapToTicks(true);
        slider.setValue(3);
        button.setTranslateX(50);
        button.setTranslateY(50);
        svgPath.setTranslateX(500);
        svgPath.setTranslateY(300);
        svgPath.setScaleX(16);
        svgPath.setScaleY(16);
        svgPath.setStroke(new RadialGradient(0,0,15,15,15.5,false, CycleMethod.NO_CYCLE,new Stop(0,Color.valueOf("#4F001B")),new Stop(0.8763,Color.valueOf("#7600FF"))));
        svgPath.setFill(new RadialGradient(0,0,15,15,15,false,CycleMethod.NO_CYCLE,new Stop(0,Color.valueOf("#9D66FF")),new Stop(0.8602,Color.valueOf("#7600FF"))));
        Group root = new Group();
        circle2.setRotate(90);
        root.getChildren().addAll( circle1, circle2,button,svgPath,slider,iosToggleButton);
        Scene scene = new Scene(root, 200, 200);
        scene.setFill(Color.AZURE);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
        button.setOnAction((ActionEvent e) -> {
            if (is_touch(circle1, circle2)) System.out.println("Yes,it did touch");
            else System.out.println("no touch");
        });
        slider.valueProperty().addListener((ObservableValue<?extends Number> ov ,Number newDouble ,Number oldDouble) ->
            ref.speed = newDouble.doubleValue());
        scene.addEventFilter(KeyEvent.KEY_PRESSED,(KeyEvent e) -> {
            if (e.getCode().equals(KeyCode.S)){circle1Y = ref.speed;}
            if (e.getCode().equals(KeyCode.W)){circle1Y = -ref.speed;}
            if (e.getCode().equals(KeyCode.A)){circle1X = -ref.speed;}
            if (e.getCode().equals(KeyCode.D)){circle1X = ref.speed;}
            if (e.getCode().equals(KeyCode.DOWN)){circle2Y = ref.speed;}
            if (e.getCode().equals(KeyCode.UP)){circle2Y = -ref.speed;}
            if (e.getCode().equals(KeyCode.LEFT)){circle2X = -ref.speed;}
            if (e.getCode().equals(KeyCode.RIGHT)){circle2X = ref.speed;}
        });
        scene.addEventFilter(KeyEvent.KEY_RELEASED,(KeyEvent e) -> {
            if (e.getCode().equals(KeyCode.S)){circle1Y =0;}
            if (e.getCode().equals(KeyCode.W)){circle1Y =0;}
            if (e.getCode().equals(KeyCode.A)){circle1X =0;}
            if (e.getCode().equals(KeyCode.D)){circle1X =0;}
            if (e.getCode().equals(KeyCode.DOWN)){circle2Y =0;}
            if (e.getCode().equals(KeyCode.UP)){circle2Y =0;}
            if (e.getCode().equals(KeyCode.LEFT)){circle2X =0;}
            if (e.getCode().equals(KeyCode.RIGHT)){circle2X =0;}
        });

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(circle1.getCenterY() <= 0){
                    circle1.setCenterY(0.25);
                }else if (circle1.getCenterY() >= 200){
                    circle1.setCenterY(199.75);
                }else{circle1.setCenterY(circle1.getCenterY() + circle1Y);}

                if(circle1.getCenterX() <= 0){
                    circle1.setCenterX(0.25);
                }else if (circle1.getCenterX() >= 200){
                    circle1.setCenterX(199.75);
                }else{circle1.setCenterX(circle1.getCenterX() + circle1X);}

                if(circle2.getCenterY() <= 0){
                    circle2.setCenterY(0.25);
                }else if (circle2.getCenterY() >= 200){
                    circle2.setCenterY(199.75);
                }else{circle2.setCenterY(circle2.getCenterY() + circle2Y);}

                if(circle2.getCenterX() <= 0){
                    circle2.setCenterX(0.01);
                }else if (circle2.getCenterX() >= 200){
                    circle2.setCenterX(199.99);
                }else{circle2.setCenterX(circle2.getCenterX() + circle2X);}

                svgPath.setRotate(svgPath.getRotate() + 1);

                /*circle1.setCenterX(circle1.getCenterX() + circle1X);
                circle2.setCenterY(circle2.getCenterY() + circle2Y);
                circle2.setCenterX(circle2.getCenterX() + circle2X);*/
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 31, 31);

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        Object z = null;
        try {
            engine.eval("var x = 10;");
            engine.eval("var y = 20;");
            engine.eval("var z = x + y");
            z = engine.eval("z");
        }catch (ScriptException ignored){}
        System.out.println(z);
    }

    private static boolean is_touch(Shape shape1,Shape shape2){
        Shape Checker = Shape.intersect(shape1,shape2);
        return Checker.getBoundsInLocal().getHeight() != -1;
    }


}
