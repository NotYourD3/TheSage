package pers.notyourd3.thesage.util;

import net.minecraft.ChatFormatting;

public class Rainbow {
    private static final ChatFormatting[] colour = new ChatFormatting[]{ChatFormatting.RED, ChatFormatting.GOLD, ChatFormatting.YELLOW, ChatFormatting.GREEN, ChatFormatting.AQUA, ChatFormatting.BLUE, ChatFormatting.LIGHT_PURPLE};

    public static String formatting(String input, ChatFormatting[] colours, double delay) {
        StringBuilder rainbow = new StringBuilder(input.length() * 3);
        if (delay <= 0.0) {
            delay = 0.001;
        }
        int offset = (int)Math.floor((double)(System.currentTimeMillis() & 0x3FFFL) / delay) % colours.length;
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            rainbow.append(colours[(colours.length + i - offset) % colours.length].toString());
            rainbow.append(c);
        }
        return rainbow.toString();
    }

    public static String makeColour(String input) {
        return Rainbow.formatting(input, colour, 100.0);
    }
}
