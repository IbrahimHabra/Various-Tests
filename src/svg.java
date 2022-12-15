import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.scene.Group;

import java.util.ArrayList;

public class svg extends Application {
        private SVGPath svgPath1 = new SVGPath();
        private SVGPath svgPath2 = new SVGPath();
        private SVGPath svgPath3 = new SVGPath();
        private ArrayList<Shape> list;
    @Override
    public void start(Stage primaryStage){
        list = new ArrayList<>();

        setPositions();
        list.add(svgPath1);
        list.add(svgPath2);
        list.add(svgPath3);
        for (Shape block:list){
            TheDragListener(block);
        }
        collision(list.get(list.size()-1));
        Group root = new Group();
        root.getChildren().addAll(list);
        primaryStage.setScene(new Scene(root,200, 200));
        primaryStage.show();

    }

    private void TheDragListener(Shape block) {
        Delta delta = new Delta();
        block.setOnMousePressed(mouseEvent -> {

            delta.x = block.getLayoutX() - mouseEvent.getSceneX();
            delta.y = block.getLayoutY() - mouseEvent.getSceneY();
            block.setCursor(Cursor.NONE);
        });
        block.setOnMouseReleased(mouseEvent ->
            block.setCursor(Cursor.HAND)
        );
        block.setOnMouseDragged(mouseEvent -> {
            System.out.println("X Position : " + mouseEvent.getSceneX());
            System.out.println("Y Position : " + mouseEvent.getSceneY());
            block.setLayoutX(delta.x + mouseEvent.getSceneX());
            block.setLayoutY(delta.y + mouseEvent.getSceneY());
            collision(block);
        });
    }

    private void collision(Shape block){
        boolean isDedicated = false;
        for (Shape blo:list){
            if(blo != block){
                blo.setFill(Color.BISQUE);
                Shape shape =Shape.intersect(block,blo);
                if(shape.getBoundsInLocal().getHeight()!= -1){
                    isDedicated = true;
                }


            }
        }
        if (isDedicated){
            block.setFill(Color.ORANGE);
        }else
        {
            block.setFill(Color.BISQUE);
        }
    }

    private void setPositions(){
        svgPath1.setContent("M418.6,429.3L278.4,220.5l-30.6,30.8l55.1,76.2l-0.3,0.2l21.7,29.5L176.8,465.8\n" +
                "\t\tc0,0.4,0,0.8-0.1,1.2l152.4,138.5h22.9l66.6-75.2v-9.7l-34.2-29.1l34.2-40.3V429.3z");
        svgPath1.setTranslateX(50);
        svgPath1.setTranslateY(150);
        svgPath2.setContent("M30.148 5.588c-2.934-3.42-7.288-5.588-12.148-5.588-8.837 0-16 7.163-16 16s7.163 16 16 16c4.86 0 9.213-2.167 12.148-5.588l-10.148-10.412 10.148-10.412zM22 3.769c1.232 0 2.231 0.999 2.231 2.231s-0.999 2.231-2.231 2.231-2.231-0.999-2.231-2.231c0-1.232 0.999-2.231 2.231-2.231z");
        svgPath2.setTranslateX(50);
        svgPath2.setTranslateY(50);
        svgPath3.setContent("M30.148 5.588c-2.934-3.42-7.288-5.588-12.148-5.588-8.837 0-16 7.163-16 16s7.163 16 16 16c4.86 0 9.213-2.167 12.148-5.588l-10.148-10.412 10.148-10.412zM22 3.769c1.232 0 2.231 0.999 2.231 2.231s-0.999 2.231-2.231 2.231-2.231-0.999-2.231-2.231c0-1.232 0.999-2.231 2.231-2.231z");
        svgPath3.setTranslateX(150);
        svgPath3.setTranslateY(50);
    }

    class Delta {
        double x,y;
    }
}
