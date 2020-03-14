class BaseList {//класс содержит все объекты класса Base
    static Base home = new Base("р. Тура", "src\\\\res\\\\Home\\\\index.jpg", new LocationList.Location[] {LocationList.homeLoc1, LocationList.homeLoc2});


    static Base[] baseList = {home};


    static class Base{
        String name;//название базы
        String pathImage;//путь к картинке расположения локаций на базе
        LocationList.Location[] locationsList;//список локаций базы

        Base(String name, String pathImage, LocationList.Location[] locationsList){
            this.name = name;
            this.pathImage = pathImage;
            this.locationsList = locationsList;
        }
    }
}
