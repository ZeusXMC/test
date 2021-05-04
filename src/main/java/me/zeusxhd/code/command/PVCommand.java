package me.zeusxhd.code.command;

import me.zeusxhd.code.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PVCommand implements CommandExecutor {

    Plugin plugin;

    public PVCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage("No... Player only!");
            return true;
        }

        Player p = (Player)sender;

        if(args.length == 0) {

            /* Open Vault */


            if(plugin.vaultInfo.containsKey(p.getUniqueId().toString())) {
                /* Are present in the Hashmap */

                String inventoryName = p.getName() + "'s Extra Inventory Vault";

                Inventory inv = Bukkit.createInventory(p, 54, inventoryName);
                p.openInventory(inv);

                return true;

            }

        }

        if(args.length == 1 && sender.hasPermission("plugin.admin")) {

            p.sendMessage("\247cInvalid args. /pv reset [player, all]");

            return true;
        }

        if(args.length == 2 && sender.hasPermission("plugin.admin")) {
            if(!args[0].equalsIgnoreCase("reset")) {

                p.sendMessage("\247cInvalid args. /pv reset [player, all]");

                return true;
            }

            if (args[1].equalsIgnoreCase("all")) {
                plugin.vaultInfo.clear();

                p.sendMessage("\247cVault GUI [everyone] cleared!");

                return true;

            }
            Player target = Bukkit.getPlayer(args[1]);
            if(target == null) {
                p.sendMessage("\247c" + args[1].toString() + " was not found..");
                p.sendMessage("\247c/pv reset [player, all]");
                return true;
            }

            if (args[1].equalsIgnoreCase(target.toString())) {
                plugin.vaultInfo.remove(target.getUniqueId().toString());

                p.sendMessage("\247cVault GUI (" + target.getName() + ") cleared!");

                return true;
            }
            if(!(
                    args[1].equalsIgnoreCase("all")
                    ||
                            args[1].equalsIgnoreCase(target.getName())
                    )

            ) {
                /* Command isn't [all/playerName] */

                p.sendMessage("\247c/pv reset [player, all]");

                return true;

            }
        }


        return false;
    }
}
