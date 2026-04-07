package p.cambiosDificultad;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DiaCommand implements CommandExecutor {

    private final boolean activate;
    private final int day;

    public DiaCommand(boolean activate, int day) {
        this.activate = activate;
        this.day = day;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        DayConfig.setDayActive(day, activate);
        sender.sendMessage(activate ? "§6Día " + day + " activado." : "§cDía " + day + " desactivado.");
        return true;
    }
}