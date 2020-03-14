class BaitsList {
static Baits bWorm = new Baits("Червь", "src\\\\Image\\\\dev\\\\pr_worm.jpg", TypeBaits.BAITS, 20, 30);
static Baits prManka = new Baits("Прикормка: Манка", "src\\\\Image\\\\dev\\\\pr_manka.gif", TypeBaits.PRIKORM, 10, 80);
static Baits arVanil = new Baits("Аромат: Ваниль", "src\\\\Image\\\\dev\\\\ar_vanil.jpg", TypeBaits.AROMA, 30, 100);

    static class Baits{
        String baitsName;
        String baitsPathImage;
        TypeBaits baitsType;
        int baitsQuantity;
        int baitsPrice;
        Baits(String baitsName, String baitsPathImage, TypeBaits baitsType, int baitsQuantity, int baitsPrice){
            this.baitsName = baitsName;
            this.baitsPathImage = baitsPathImage;
            this.baitsType = baitsType;
            this.baitsQuantity = baitsQuantity;
            this.baitsPrice = baitsPrice;
        }
    }
}
enum TypeBaits{
    BAITS,
    PRIKORM,
    AROMA
}
