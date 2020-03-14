class KatushkaList {
static Katushka katushka_1 = new Katushka("Daiwa", "src\\\\Image\\\\dev\\\\kt_daiwa.jpg", 5000, 1, 50);
static Katushka katushka_2 = new Katushka("Cardinal", "src\\\\Image\\\\dev\\\\kt_cardinal.jpg", 10000, 3, 300);

    static class Katushka{
        String katName;
        String katPathImage;
        double katCapacity;
        int katPodshipQuantity;
        int katPrice;
        Katushka(String katName, String katPathImage, double katCapacity, int katPodshipQuantity, int katPrice){
            this.katName = katName;
            this.katPathImage = katPathImage;
            this.katCapacity = katCapacity;
            this.katPodshipQuantity = katPodshipQuantity;
            this.katPrice = katPrice;
        }
    }
}
