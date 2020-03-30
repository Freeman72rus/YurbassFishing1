import javax.swing.*;

class SpinningList {
static Spinning spinning_1 = new Spinning(0,"Lord",new ImageIcon(SpinningList.class.getResource("/Image/dev/sp_lord.jpg")), 3000, 150, 100);
static Spinning spinning_2 = new Spinning(0,"Cottus 000", new ImageIcon(SpinningList.class.getResource("/Image/dev/sp_cottus 000.jpg")), 4000, 200, 100);


static Spinning[] spinningList = {spinning_1, spinning_2};
    static class Spinning{
        int spinCount;
        String spinName;//название
        ImageIcon spinPathImage;
        double spinCapacity;//грузоподъемность
        int spinPrice;//цена
        int spinSafety;//сохранность
        Spinning(int spinCount, String spinName, ImageIcon spinPathImage, double spinCapacity, int spinPrice, int spinSafety){
            this.spinCount = spinCount;
            this.spinName = spinName;
            this.spinPathImage = spinPathImage;
            this.spinCapacity = spinCapacity;
            this.spinPrice = spinPrice;
            this.spinSafety = spinSafety;
        }
    }
}
