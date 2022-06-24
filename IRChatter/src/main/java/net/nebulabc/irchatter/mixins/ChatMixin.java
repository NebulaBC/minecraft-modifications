package net.nebulabc.irchatter.mixins;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHudListener;
import net.minecraft.client.gui.screen.MessageScreen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.util.ChatMessages;
import net.minecraft.network.message.MessageSender;
import net.minecraft.network.message.MessageType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.nebulabc.irchatter.IRChatter;
import net.nebulabc.irchatter.tools.IRCLIENT;
import org.kitteh.irc.client.library.Client;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatHudListener.class)
public class ChatMixin {
    @Inject(at = @At("HEAD"), method = "onChatMessage", cancellable = true)
    private void onSend(MessageType type, Text message, MessageSender sender, CallbackInfo ci) {
        assert MinecraftClient.getInstance().player != null;
        if (sender.uuid() == MinecraftClient.getInstance().player.getUuid()) {
            if (IRChatter.client == null) {
                IRChatter.client = Client.builder().nick(String.valueOf(MinecraftClient.getInstance().player.getName()).replaceAll("^literal\\{|.$", "")).server().host("127.0.0.1").port(6667).secure(false).then().buildAndConnect();
            }
            IRCLIENT.sendMessage(String.valueOf(message).replaceAll("^literal\\{|.$", ""));
            ci.cancel();
            MinecraftClient.getInstance().player.sendMessage(Text.of("§b[IRC]§r <" + String.valueOf(MinecraftClient.getInstance().player.getName()).replaceAll("^literal\\{|.$", "") + "> " + String.valueOf(message).replaceAll("^literal\\{|.$", "")));
        } else {
            ci.cancel();
        }

    }
}