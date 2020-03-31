import javax.swing.*;

class BaitsList {
static Baits bWorm = new Baits("Червь", new ImageIcon(BaitsList.class.getResource("/Image/dev/pr_worm.jpg")), new ImageIcon(BaitsList.class.getResource("/Image/dev/small/pr_worm.jpg")), TypeBaits.BAITS, 20, 30, -1);
static Baits prManka = new Baits("Прикормка: Манка", new ImageIcon(BaitsList.class.getResource("/Image/dev/pr_manka.gif")), null, TypeBaits.PRIKORM, 10, 80, -1);
static Baits arVanil = new Baits("Аромат: Ваниль", new ImageIcon(BaitsList.class.getResource("/Image/dev/ar_vanil.jpg")), null, TypeBaits.AROMA, 30, 100, -1);


static Baits[] baitsList = {bWorm, prManka, arVanil};
    static class Baits{
        String baitsName;
        ImageIcon baitsPathImage;
        ImageIcon baitsSmallImage;
        TypeBaits baitsType;
        int baitsQuantity;
        int baitsPrice;
        int tackleNumber;
        Baits(String baitsName, ImageIcon baitsPathImage, ImageIcon baitsSmallImage, TypeBaits baitsType, int baitsQuantity, int baitsPrice, int tackleNumber){
            this.baitsName = baitsName;
            this.baitsPathImage = baitsPathImage;
            this.baitsSmallImage = baitsSmallImage;
            this.baitsType = baitsType;
            this.baitsQuantity = baitsQuantity;
            this.baitsPrice = baitsPrice;
            this.tackleNumber = tackleNumber;
        }
    }
}
enum TypeBaits{
    BAITS,
    PRIKORM,
    AROMA
}
