package plugin.specialitems.holy;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HolyUtil {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private static final String date = "§8• §7Gecraftet: §a" + simpleDateFormat.format(new Date());

    public static final String holyGradient = "<gradient:#ebf672:#f2fcbd>";

    public static Component createName(String name){
        return MiniMessage.miniMessage().deserialize("<i:false><obf><#f2fcbd>aa</obf> <b>" + HolyUtil.holyGradient  + name + " </b><obf><#f2fcbd>aa");
    }

}
