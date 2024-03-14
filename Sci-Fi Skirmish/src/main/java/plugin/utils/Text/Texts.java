package plugin.utils.Text;

public class Texts {

    public static String get(String s){
        return switch (s) {
            case "crate" -> "<gradient:#FFE259:#FFA751>Nachschubkiste";
            case "common" -> "<gradient:#00B93A:#246906>Gewöhnlich";
            case "uncommon" -> "<gradient:#008DDF:#064569>Selten";
            case "epic" -> "<gradient:#7800DF:#600669>Episch";
            case "rare" -> "<gradient:#D3DF00:#EE8109>Legendär";
            case "mythic" -> "<gradient:#00DFCD:#0A8050>Mythisch";
            default -> "DA FEHLT WAS ODER IST FALSCH EINGEGEBEN JAN";
        };
    }

    public static String gradient(String gradientColor, String gradientText){
        return switch (gradientColor){
            case "scifi" -> "<gradient:ffffff:000000>" + gradientText + "</gradient>";
            case "sticky" -> "sadasd";
            default -> "DA FEHLT WAS ODER IST FALSCH EINGEGEBEN JAN";
        };
    }
}
