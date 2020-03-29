class HookList {
static Hook hook_1 = new Hook("viper", "src\\\\Image\\\\dev\\\\hk_viper.jpg", 20, 10, 10, -1);
static Hook hook_2 = new Hook("fisher", "src\\\\Image\\\\dev\\\\hk_fisher.jpg", 30, 10, 20, -1);

static Hook[] hookList = {hook_1, hook_2};
    static class Hook{
        String hookName;
        String hookPathImage;
        int hookQuality;
        int hookQuantity;
        int hookPrice;
        int tackleNumber;
        Hook(String hookName, String hookPathImage, int hookQuality, int hookQuantity, int hookPrice, int tackleNumber){
            this.hookName = hookName;
            this.hookPathImage = hookPathImage;
            this.hookQuality = hookQuality;
            this.hookQuantity = hookQuantity;
            this.hookPrice = hookPrice;
            this.tackleNumber = tackleNumber;
        }
    }
}
