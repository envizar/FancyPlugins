package de.oliver.fancynpcs.commands.npc;

import de.oliver.fancylib.translations.Translator;
import de.oliver.fancynpcs.FancyNpcs;
import de.oliver.fancynpcs.api.Npc;
import org.bukkit.command.CommandSender;
import org.incendo.cloud.annotations.Command;
import org.incendo.cloud.annotations.Permission;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum SpawnEntityCMD {
    INSTANCE; // SINGLETON

    private final Translator translator = FancyNpcs.getInstance().getTranslator();

    @Command("npc spawnEntity <npc> [state]")
    @Permission("fancynpcs.command.npc.show_in_tab")
    public void onCommand(
            final @NotNull CommandSender sender,
            final @NotNull Npc npc,
            final @Nullable Boolean state
    ) {
        final boolean finalState = (state != null) ? state : !npc.getData().isSpawnEntity();
        npc.getData().setSpawnEntity(finalState);
        if (finalState) {
            npc.spawnForAll();
        } else {
            npc.removeForAll();
        }
    }

}
