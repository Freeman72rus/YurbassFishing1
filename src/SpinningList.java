class SpinningList {
static Spinning spinning_1 = new Spinning("Lord","src\\\\Image\\\\dev\\\\sp_lord.jpg", 3000, 150, 100);
static Spinning spinning_2 = new Spinning("Cottus 000", "src\\\\Image\\\\dev\\\\sp_cottus 000.jpg", 4000, 200, 100);

    static class Spinning{
        String spinName;//название
        String spinPathImage;
        double spinCapacity;//грузоподъемность
        int spinPrice;//цена
        int spinSafety;//сохранность
        Spinning(String spinName, String spinPathImage, double spinCapacity, int spinPrice, int spinSafety){
            this.spinName = spinName;
            this.spinPathImage = spinPathImage;
            this.spinCapacity = spinCapacity;
            this.spinPrice = spinPrice;
            this.spinSafety = spinSafety;
        }
    }
}
