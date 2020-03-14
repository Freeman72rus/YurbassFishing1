import java.awt.*;

class LocationList {//Класс реализует локации
    static Location homeLoc1 = new Location("src\\\\res\\\\Home\\\\Loc_1_Day.jpg", "src\\\\res\\\\Home\\\\Loc_1_Night.jpg", 200, 200, new FishList.Fish[]{FishList.plotva});
    static Location homeLoc2 = new Location("src\\\\res\\\\Home\\\\Loc_2_Day.jpg", "src\\\\res\\\\Home\\\\Loc_2_Night.jpg", 390, 230, new FishList.Fish[]{FishList.plotva});



    static class Location{
        String locImageDayPath;//путь к картинке локации днем
        String locImageNightPath;//путь к картинке локации ночью
        int x;//координаты локации на карте локаций
        int y;
        FishList.Fish[] locFish;//Список обитающих рыб
        /*int[] amountFish;//количество рыб на локации
        int[] locDepth;//сетка глубин локации
        int[] zacepi;//сетка зацепов*/

        public Location(String locImageDayPath, String locImageNightPath, int x, int y, FishList.Fish[] locFish/*, int[] amountFish, int[] locDepth, int[] zacepi*/){//Дописать конструктор
            this.locImageDayPath = locImageDayPath;
            this.locImageNightPath = locImageNightPath;
            this.x = x;
            this.y = y;
            this.locFish = locFish;
            /*this.amountFish = amountFish;
            this.locDepth = locDepth;
            this.zacepi = zacepi;*/
        }
    }
    public static void main(String[]args){
        System.out.println(homeLoc1.locFish[0].fishName);
    }
}


