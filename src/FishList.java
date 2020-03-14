import java.awt.*;

class FishList {//Класс реализует рыбы
static Fish plotva = new Fish("Плотва обыкновенная", "src\\Image\\fish\\plotva.jpg", 0, 100, 2000);



    static class Fish{
        String fishName;//Имя рыбы
        String fishImagePath;
        double fishWeight;
        int minWeight;//Минимальный вес
        int maxWeight;//Максимальный вес
        /*int setWeight;//Зачётный вес
        int minDepth;//Минимальная глубина обитания
        int maxDepth;//Максимальная глубина обитания
        int bottom;//Активность рыбы на дне
        int center;//Активность рыбы в толще воды
        int top;//Активность рыбы у поверхности
        int dayActiv;//Активность днемж
        int nightActiv;//Активность ночью
        int[] baitsNibble;//Вероятность клёва на наживки
        int fishPrice;//цена рыбы за вес weightPrice
        int weightPrice;//вес рыбы за который указывается цена fishPrice
        int expFish;// Опыт который дают за каждые weightExp грамм пойманной рыбы
        int weightExp;
        int accuracyNibble;//Аккуратность клёва рыбы
        int characterNibble;//Характер поклёвки
        int[] prikNibble;//вероятность клёва при использовании основы прикормки
        int[] aromaNibble;//вероятность клёва при использовании ароматизатора для прикормки
        int licenseType;//тип необходимой лицензии*/

        Fish(String fishName, String fishImagePath, double fishWeight, int minWeight, int maxWeight/*, int setWeight, int minDepth, int maxDepth, int bottom, int center, int top, int dayActiv, int nightActiv,
                 int[] baitsNibble, int fishPrice, int weightPrice, int expFish, int weightExp, int accuracyNibble, int characterNibble, int[] prikNibble, int[] aromaNibble, int licenseType*/){
            this.fishImagePath = fishImagePath;
            this.fishWeight = fishWeight;
            this.fishName = fishName;
            this.minWeight = minWeight;
            this.maxWeight = maxWeight;
            /*this.setWeight = setWeight;
            this.minDepth = minDepth;
            this.maxDepth = maxDepth;
            this.bottom = bottom;
            this.center = center;
            this.top = top;
            this.dayActiv = dayActiv;
            this.nightActiv = nightActiv;
            this.baitsNibble = baitsNibble;
            this.fishPrice = fishPrice;
            this.weightPrice = weightPrice;
            this.expFish = expFish;
            this.weightExp = weightExp;
            this.accuracyNibble = accuracyNibble;
            this.characterNibble = characterNibble;
            this.prikNibble = prikNibble;
            this.aromaNibble = aromaNibble;
            this.licenseType = licenseType;*/
        }
    }
}
