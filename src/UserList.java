class UserList{
static User player1 = new User("ЮРИК", "р. Тура", 500L, 0L);

static User[] users = {player1};



    static class User {
        String userName;//Имя юзера
        String baseNow; //Название базы на которой юзер сейчас находится
        long userMoney;//Дениги Юзера
        long userExp;//Очки опыта Юзера

        User(String userName, String baseNow, long userMoney, long userExp){
            this.userName = userName;
            this.baseNow = baseNow;
            this.userMoney = userMoney;
            this.userExp = userExp;
        }
    }
}
