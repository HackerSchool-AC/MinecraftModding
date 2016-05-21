package hackerschool.aachen.minecraftmod;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.ClientCommandHandler;

public class VerzweigungsBeispiel {
    public class GetCommand extends CommandBase {

        @Override
        public String getCommandName() {
            return "get";
        }

        @Override
        public String getCommandUsage(ICommandSender sender) {
            return "/get [name|time]";
        }

        @Override
        public void processCommand(ICommandSender sender, String[] args) throws CommandException {
            if (args.length == 0) {
                sender.addChatMessage(new ChatComponentText("Nutze: " + getCommandUsage(sender)));
                return;
            }

            if (args[0].equals("name")) {
                sender.addChatMessage(sender.getDisplayName());
            } else if (args[0].equalsIgnoreCase("time")) {
                long time = sender.getEntityWorld().getWorldTime();
                sender.addChatMessage(new ChatComponentText(Long.toString(time)));
            } else {
                String msg = String.format("%s unbekannt. Nutze: %s", args[0], getCommandUsage(sender));
                sender.addChatMessage(new ChatComponentText(msg));
            }
        }

        @Override
        public int getRequiredPermissionLevel() {
            return 0;
        }
    }

    public VerzweigungsBeispiel() {
        ClientCommandHandler.instance.registerCommand(new GetCommand());
    }
}
