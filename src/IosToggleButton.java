
import javafx.animation.FillTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

  class IosToggleButton extends Group{
        private Rectangle rectangle = new Rectangle();
        private Circle circle = new Circle();
        private TranslateTransition translateTransition = new TranslateTransition();
        private FillTransition fillTransition = new FillTransition();

        IosToggleButton(int Size,boolean isSelected,int stroke) {
            final boolean[] isSelected1 = {isSelected};
            rectangle.setHeight(Size);
            rectangle.setWidth(Size * 2);
            circle.setRadius(Size / 2);
            rectangle.setTranslateX(this.getTranslateX());
            rectangle.setTranslateY(this.getTranslateY());
            circle.setCenterX(circle.getRadius() + this.getTranslateX());
            circle.setCenterY(circle.getRadius() + this.getTranslateY());
            rectangle.setStrokeWidth(stroke);
            circle.setStrokeWidth(stroke);
            rectangle.setStroke(Color.GRAY);
            rectangle.setArcWidth(100);
            rectangle.setArcHeight(100);
            circle.setStroke(Color.GRAY);
            circle.setFill(Color.LIGHTGRAY);
            if (isSelected1[0]) {
                translateTransition.setToX(0);
                translateTransition.setNode(circle);
                translateTransition.play();
            }else{
                translateTransition.setToX(Size);
                translateTransition.setNode(circle);
                translateTransition.play();
            }
            rectangle.setFill(isSelected1[0] ? Color.LIGHTGRAY:Color.LIGHTGREEN);
            this.getChildren().addAll(rectangle, circle);
            translateTransition.setRate(2.5);
            fillTransition.setRate(2.5);
            this.setOnMouseClicked((MouseDragEvent) -> {
                if (isSelected1[0]){
                    fillTransition.setToValue(Color.LIGHTGREEN);
                    fillTransition.setShape(rectangle);
                    translateTransition.setToX(Size);
                    translateTransition.setNode(circle);
                    fillTransition.play();
                    translateTransition.play();
                    isSelected1[0] = false;
                }
                else {
                    fillTransition.setToValue(Color.LIGHTGRAY);
                    fillTransition.setShape(rectangle);
                    translateTransition.setToX(0);
                    translateTransition.setNode(circle);
                    translateTransition.play();
                    fillTransition.play();
                    isSelected1[0] = true;
                }

            });
        }
 }
