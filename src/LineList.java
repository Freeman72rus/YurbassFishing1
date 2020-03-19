class LineList {
    static String linePathImage = "src\\\\Image\\\\dev\\\\leska.jpg";

static Line line_1 = new Line("2 кг", linePathImage, 2000, 80, 50, -1);
static  Line line_2 = new Line("3 кг", linePathImage, 3000, 80, 70, -1);


static Line[] lineList = {line_1, line_2};
    static class Line{
        String lineName;
        String linePathImage;
        double lineCapacity;
        int lineLength;
        int linePrice;
        int tackleNumber;
        Line(String lineName, String linePathImage, double lineCapacity, int lineLength, int linePrice, int tackleNumber){
            this.lineName = lineName;
            this.linePathImage = linePathImage;
            this.lineCapacity = lineCapacity;
            this.lineLength = lineLength;
            this.linePrice = linePrice;
            this.tackleNumber = tackleNumber;
        }
    }
}
