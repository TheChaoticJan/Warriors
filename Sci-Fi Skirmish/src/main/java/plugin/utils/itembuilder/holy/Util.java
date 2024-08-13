package plugin.utils.itembuilder.holy;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class Util {

    public static final String holyGradient = "<gradient:#ebf672:#f2fcbd>";

    public static Component createName(String name){
        return MiniMessage.miniMessage().deserialize("<i:false><obf><#f2fcbd>aa</obf> <b><white>[" + Util.holyGradient + "Heilig</gradient><white>] <yellow>" + name + "</yellow> </b><obf><#97ad23>aa");
    }

}
