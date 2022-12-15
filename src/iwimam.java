
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

class iwimam extends ArrayList<Shape> {
    iwimam(){
        String st0 = "fill:#;stroke:;stroke-width:16;stroke-miterlimit:10;";
        String st1 = "fill:#A1C518;stroke:#231E49;stroke-width:16.6425;stroke-miterlimit:10;";
        String st2 = "fill:#A1C518;stroke:#231E49;stroke-width:13.8768;stroke-miterlimit:10;";
        String st3 = "fill:#A1C518;stroke:#231E49;stroke-width:17.6073;stroke-miterlimit:10;";
        String st4 = "fill:#A1C518;stroke:#231E49;stroke-width:18.6854;stroke-miterlimit:10;";
        SVGPath svgPath1 = new SVGPath();
        svgPath1.setFill(Color.valueOf("#A1C518"));
        svgPath1.setStroke(Color.valueOf("#231E49"));
        svgPath1.setStrokeWidth(16);
        Line line1 = new Line(247.9,251.3,385.2,434);
        svgPath1.setTranslateY(-300);
        Line line2 = new Line(376.6,431.5,308.1,488.7);
        Line line3 = new Line(312.3,494.6,289.7,467.6);
        Line line4 = new Line(281.1,469.2,310.6,445.2);
        Line line5 = new Line(384.3,491.6,324.3,550.6);
        Line line6 = new Line(327.6,555,230.1,460.1);
        Line line7 = new Line(235.6,464.5,310.5,403.5);
        Line line8 = new Line(305.6,398.5,335.7,438.9);
        svgPath1.setContent("M418.6,429.3L278.4,220.5l-30.6,30.8l55.1,76.2l-0.3,0.2l21.7,29.5L176.8,465.8 c0,0.4,0,0.8-0.1,1.2l152.4,138.5h22.9l66.6-75.2v-9.7l-34.2-29.1l34.2-40.3V429.3z");
        svgPath1.setStyle(st0);
        line1.setStyle(st1);
        line2.setStyle(st2);
        line3.setStyle(st0);
        line4.setStyle(st0);
        line5.setStyle(st0);
        line6.setStyle(st3);
        line7.setStyle(st0);
        line8.setStyle(st4);
        this.add(svgPath1);
        this.add(line1);
        this.add(line2);
        this.add(line3);
        this.add(line4);
        this.add(line5);
        this.add(line6);
        this.add(line7);
        this.add(line8);
    }
}
