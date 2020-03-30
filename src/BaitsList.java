import javax.swing.*;

class BaitsList {
static Baits bWorm = new Baits("Червь", new ImageIcon(BaitsList.class.getResource("/Image/dev/pr_worm.jpg")), TypeBaits.BAITS, 20, 30);
static Baits prManka = new Baits("Прикормка: Манка", new ImageIcon(BaitsList.class.getResource("/Image/dev/pr_manka.gif")), TypeBaits.PRIKORM, 10, 80);
static Baits arVanil = new Baits("Аромат: Ваниль", new ImageIcon(BaitsList.class.getResource("/Image/dev/ar_vanil.jpg")), TypeBaits.AROMA, 30, 100);


static Baits[] baitsList = {bWorm, prManka, arVanil};
    static class Baits{
        String baitsName;
        ImageIcon baitsPathImage;
        TypeBaits baitsType;
        int baitsQuantity;
        int baitsPrice;
        Baits(String baitsName, ImageIcon baitsPathImage, TypeBaits baitsType, int baitsQuantity, int baitsPrice){
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
