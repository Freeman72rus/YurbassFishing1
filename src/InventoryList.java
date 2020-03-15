class InventoryList {
    static SpinningList.Spinning[] spinningsUser1 = new SpinningList.Spinning[100];
    static LineList.Line[] linesUser1 = new LineList.Line[100];
    static HookList.Hook[] hooksUser1 = new HookList.Hook[100];
    static SpoonList.Spoon[] spoonsUser1 = new SpoonList.Spoon[100];
    static BaitsList.Baits[] baitsUser1 = new BaitsList.Baits[100];
    static KatushkaList.Katushka[] katUser1 = new KatushkaList.Katushka[100];
static Inventory inventory1 = new Inventory(spinningsUser1, linesUser1, hooksUser1, spoonsUser1, baitsUser1, katUser1);


static Inventory[] inventoriList = {inventory1};
    static class Inventory{
        SpinningList.Spinning[] spinningsUser = new SpinningList.Spinning[100];
        LineList.Line[] linesUser = new LineList.Line[100];
        HookList.Hook[] hooksUser = new HookList.Hook[100];
        SpoonList.Spoon[] spoonsUser = new SpoonList.Spoon[100];
        BaitsList.Baits[] baitsUser = new BaitsList.Baits[100];
        KatushkaList.Katushka[] katUser = new KatushkaList.Katushka[100];
        Inventory(SpinningList.Spinning[] spinningsUser, LineList.Line[] linesUser, HookList.Hook[] hooksUser, SpoonList.Spoon[] spoonsUser, BaitsList.Baits[]baitsUser, KatushkaList.Katushka[] katUser){
            this.spinningsUser = spinningsUser;
            this.linesUser = linesUser;
            this.hooksUser = hooksUser;
            this.spoonsUser = spoonsUser;
            this.baitsUser = baitsUser;
            this.katUser = katUser;
        }
    }
}
