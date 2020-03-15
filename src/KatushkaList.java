class KatushkaList {
static Katushka katushka_1 = new Katushka("Daiwa", "src\\\\Image\\\\dev\\\\kt_daiwa.jpg", 5000, 1, 50, 100);
static Katushka katushka_2 = new Katushka("Cardinal", "src\\\\Image\\\\dev\\\\kt_cardinal.jpg", 10000, 3, 300, 100);

static Katushka[] katushkaList = {katushka_1, katushka_2};
    static class Katushka{
        String katName;
        String katPathImage;
        double katCapacity;
        int katPodshipQuantity;
        int katPrice;
        int katSafety;
        Katushka(String katName, String katPathImage, double katCapacity, int katPodshipQuantity, int katPrice, int katSafety){
            this.katName = katName;
            this.katPathImage = katPathImage;
            this.katCapacity = katCapacity;
            this.katPodshipQuantity = katPodshipQuantity;
            this.katPrice = katPrice;
            this.katSafety = katSafety;
        }
    }
}
