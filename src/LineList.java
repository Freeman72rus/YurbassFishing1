import javax.swing.*;

class LineList {
    static final ImageIcon linePathImage = new ImageIcon(LineList.class.getResource("/Image/dev/leska.jpg"));
    static final ImageIcon lineSmallImage = new ImageIcon(LineList.class.getResource("/Image/dev/small/leska.jpg"));

static Line line_1 = new Line("2 кг", linePathImage, lineSmallImage, 2000, 80, 50, -1, false);
static  Line line_2 = new Line("3 кг", linePathImage, lineSmallImage, 3000, 80, 70, -1, false);


static Line[] lineList = {line_1, line_2};
    static class Line{
        String lineName;
        ImageIcon linePathImage;
        ImageIcon lineSmallImage;
        double lineCapacity;
        int lineLength;
        int linePrice;
        int tackleNumber;
        boolean tackleSelect;
        Line(String lineName, ImageIcon linePathImage, ImageIcon lineSmallImage, double lineCapacity, int lineLength, int linePrice, int tackleNumber, boolean tackleSelect){
            this.lineName = lineName;
            this.linePathImage = linePathImage;
            this.lineSmallImage = lineSmallImage;
            this.lineCapacity = lineCapacity;
            this.lineLength = lineLength;
            this.linePrice = linePrice;
            this.tackleNumber = tackleNumber;
            this.tackleSelect = tackleSelect;
        }
    }
}
