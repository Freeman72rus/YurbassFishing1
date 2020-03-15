class UserList{
static User player1 = new User("ЮРИК", "р. Тура", 500L, 0L, InventoryList.inventory1);

static User[] users = {player1};



    static class User {
        String userName;//Имя юзера
        String baseNow; //Название базы на которой юзер сейчас находится
        long userMoney;//Дениги Юзера
        long userExp;//Очки опыта Юзера
        InventoryList.Inventory inventory;

        User(String userName, String baseNow, long userMoney, long userExp, InventoryList.Inventory inventory){
            this.userName = userName;
            this.baseNow = baseNow;
            this.userMoney = userMoney;
            this.userExp = userExp;
            this.inventory = inventory;
        }
    }
}
