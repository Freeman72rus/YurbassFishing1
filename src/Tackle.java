class Tackle{
        SpinningList.Spinning spinT;
        LineList.Line lineT;
        HookList.Hook hookT;
        SpoonList.Spoon spoonT;
        BaitsList.Baits baitsT;
        KatushkaList.Katushka katushkaT;

        Tackle(SpinningList.Spinning spinT){
            this.spinT = spinT;
        }
        Tackle(SpinningList.Spinning spinT, KatushkaList.Katushka katushkaT){
            this.spinT = spinT;
            this.katushkaT = katushkaT;
        }
        Tackle(SpinningList.Spinning spinT, KatushkaList.Katushka katushkaT, LineList.Line lineT){
            this.spinT = spinT;
            this.katushkaT = katushkaT;
            this.lineT = lineT;
        }
        Tackle(SpinningList.Spinning spinT, KatushkaList.Katushka katushkaT, LineList.Line lineT, SpoonList.Spoon spoonT){
            this.spinT = spinT;
            this.katushkaT = katushkaT;
            this.lineT = lineT;
            this.spoonT = spoonT;
        }
        Tackle(SpinningList.Spinning spinT, KatushkaList.Katushka katushkaT, LineList.Line lineT, HookList.Hook hookT){
            this.spinT = spinT;
            this.katushkaT = katushkaT;
            this.lineT = lineT;
            this.hookT = hookT;
        }
        Tackle(SpinningList.Spinning spinT, KatushkaList.Katushka katushkaT, LineList.Line lineT, HookList.Hook hookT, BaitsList.Baits baitsT){
            this.spinT = spinT;
            this.katushkaT = katushkaT;
            this.lineT = lineT;
            this.hookT = hookT;
            this.baitsT = baitsT;
        }
}
