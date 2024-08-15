package de.jonasheilig.suits.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class GetItemCommandCompleter : TabCompleter {

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): List<String>? {
        if (sender !is Player) {
            return null
        }

        if (args.size == 1) {
            return sender.server.onlinePlayers.map { it.name }
        }

        if (args.size == 2) {
            val items = listOf(
                "ironman_helmet",
                "ironman_chestplate",
                "ironman_leggings",
                "ironman_boots",
                "ironman_ark_reactor",
                "ironman_jarvis",
                )
            return items.filter { it.startsWith(args[1], true) }
        }

        return null
    }
}