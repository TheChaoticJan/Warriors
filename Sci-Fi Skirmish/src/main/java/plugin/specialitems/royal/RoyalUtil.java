package plugin.specialitems.royal;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import plugin.specialitems.holy.HolyUtil;

public class RoyalUtil {

    public static final String royalGradient = "<gradient:yellow:aqua>";

    public static Component createName(String name) {
        return MiniMessage.miniMessage().deserialize("<i:false><obf><yellow>aa</obf> <gradient:yellow:aqua><b>" + name + " <obf><aqua>aa</obf>");

    }
}
