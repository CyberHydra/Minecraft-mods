package net.minecraft.src;

public class GuiOldDaysModules extends GuiOldDaysBase{
    public GuiOldDaysModules(GuiScreen guiscreen, mod_OldDays core){
        super(guiscreen, core);
    }

    public void initGui(){
        super.initGui();
        int count = mod_OldDays.modules.size();
        for (int i = 0; i < count; i++){
            OldDaysModule module = mod_OldDays.modules.get(i);
            if (module == null){
                continue;
            }
            addButton(module.id, true, module.id, mod_OldDays.lang.get("module."+module.name.toLowerCase()), true);
        }
        postInitGui(count);
        maxpage /= 2;
        controlList.add(new GuiButton(100, width / 2 - 155, height - 28, 75, 20, mod_OldDays.lang.get("gui.ssp")+": "+mod_OldDays.lang.get(mc.useSP ? "gui.on" : "gui.off")));
        controlList.add(new GuiButton(101, width / 2 + 81, height - 28, 75, 20, mod_OldDays.lang.get("gui.presets")));
    }

    protected void actionPerformed(GuiButton guibutton)
    {
        super.actionPerformed(guibutton);
        if (guibutton.id == 100){
            mc.useSP = !mc.useSP;
            guibutton.displayString = mod_OldDays.lang.get("gui.ssp")+": "+mod_OldDays.lang.get(mc.useSP ? "gui.on" : "gui.off");
            mod_OldDays.saveman.saveCoreProperties();
            mc.switchSSP(mc.useSP);
            return;
        }
        if (guibutton.id == 101){
            GuiOldDaysPresets presets = new GuiOldDaysPresets(this, core);
            mc.displayGuiScreen(presets);
            return;
        }
        if (guibutton.id <= 0 || guibutton.id >= LEFT_ID){
            return;
        }
        if (!guibutton.enabled){
            return;
        }
        mc.displayGuiScreen(new GuiOldDaysSettings(this, core, guibutton.id-1));
    }
}