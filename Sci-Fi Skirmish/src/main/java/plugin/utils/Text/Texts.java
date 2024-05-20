package plugin.utils.Text;

import java.util.Random;

public class Texts {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789ÄÖÜäöü;,:._-";
    private static final Random RANDOM = new Random();

    public static String generateRandomString(int STRING_LENGTH) {
        StringBuilder stringBuilder = new StringBuilder(STRING_LENGTH);
        for (int i = 0; i < STRING_LENGTH; i++) {
            int randomIndex = RANDOM.nextInt(CHARACTERS.length());
            stringBuilder.append(CHARACTERS.charAt(randomIndex));
        }
        return stringBuilder.toString();
    }

    public static String stringToMiniMessage(String s) {
        return s
                .replace("&f", "<white>")
                .replace("&d", "<light_purple>")
                .replace("&1", "<dark_blue>")
                .replace("&2", "<dark_green>")
                .replace("&3", "<dark_aqua>")
                .replace("&4", "<dark_red>")
                .replace("&5", "<dark_purple>")
                .replace("&6", "<gold>")
                .replace("&7", "<gray>")
                .replace("&8", "<dark_gray>")
                .replace("&9", "<blue>")
                .replace("&a", "<green>")
                .replace("&c", "<red>")
                .replace("&e", "<yellow>")
                .replace("&b", "<aqua>")
                .replace("&0", "<black>")
                .replace("&m", "<st>")
                .replace("&n", "<u>")
                .replace("&l", "<b>")
                .replace("&r", "<reset>")
                .replace("&o", "<i>")
                .replace("&k", "<obf>");
    }

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

    public static String setRankGradient(String rank){
        return switch (rank) {
            case "Spieler" -> "<gradient:#FFE259:#FFA751>";
            case "Moderator" -> "<gradient:#7034E6:#b76eec>";
            case "Admin" -> "<gradient:#FF0000:#ad0d34>";
            default -> "Da ist was falsch Jan";
        };
    }
}
