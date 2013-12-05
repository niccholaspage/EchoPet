package io.github.dsh105.echopet.logger;

import io.github.dsh105.echopet.EchoPet;
import org.bukkit.command.ConsoleCommandSender;


public class ConsoleLogger {

    private static ConsoleCommandSender console;

    public static void initiate() {
        console = EchoPet.getInstance().getServer().getConsoleSender();
    }

    public static void log(Logger.LogLevel logLevel, String message) {
        console.sendMessage(logLevel.getPrefix() + " " + message);
    }

    public static void log(String message) {
        log(Logger.LogLevel.NORMAL, message);
    }

    public static void stackTraceAlert(Logger.LogLevel logLevel, String message) {
        console.sendMessage(logLevel.getPrefix() + " " + message);
        console.sendMessage(logLevel.getPrefix() + " See the Log File for details [EchoPet.log].");
    }
}
