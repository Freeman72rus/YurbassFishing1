import javax.swing.*;

class HookList {
static Hook hook_1 = new Hook("viper", new ImageIcon(HookList.class.getResource("/Image/dev/hk_viper.jpg")), new ImageIcon(HookList.class.getResource("/Image/dev/small/hk_viper.jpg")), 20, 10, 10, -1);
static Hook hook_2 = new Hook("fisher", new ImageIcon(HookList.class.getResource("/Image/dev/hk_fisher.jpg")), new ImageIcon(HookList.class.getResource("/Image/dev/small/hk_fisher.jpg")), 30, 10, 20, -1);

static Hook[] hookList = {hook_1, hook_2};
    static class Hook{
        String hookName;
        ImageIcon hookPathImage;
        ImageIcon hookSmallImage;
        int hookQuality;
        int hookQuantity;
        int hookPrice;
        int tackleNumber;
        Hook(String hookName, ImageIcon hookPathImage, ImageIcon hookSmallImage, int hookQuality, int hookQuantity, int hookPrice, int tackleNumber){
            this.hookName = hookName;
            this.hookPathImage = hookPathImage;
            this.hookSmallImage = hookSmallImage;
            this.hookQuality = hookQuality;
            this.hookQuantity = hookQuantity;
            this.hookPrice = hookPrice;
            this.tackleNumber = tackleNumber;
        }
    }
}
