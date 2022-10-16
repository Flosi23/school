public class Main {

    String state = "S";

    private String consume(char ch) {
        return switch (state) {
            case "S" -> switch (ch) {
                case 'D' -> "L1";
                default -> "-1";
            };
            case "L1" -> switch (ch) {
                case 'E' -> "L2";
                case ' ', '-' -> "T1";
                default -> "-1";
            };
            case "L2" -> switch (ch) {
                case ' ', '-' -> "T1";
                default -> "-1";
            };
            case "T1" -> switch (ch) {
                case 'B' -> "B1";
                default -> "-1";
            };
            case "B1" -> switch (ch) {
                case 'W', 'Y' -> "B2";
                default -> "-1";
            };
            case "B2" -> switch (ch) {
                case ' ' -> "T2";
                default -> "-1";
            };
            case "T2" -> switch (ch) {
                case '0','1','2','3','4','5','6','7','8','9' -> "N1";
                default -> "-1";
            };
            case "N1" -> switch (ch) {
                case '0','1','2','3','4','5','6','7','8','9' -> "N2";
                default -> "-1";
            };
            case "N2" -> switch (ch) {
                case '0','1','2','3','4','5','6','7','8','9' -> "N3";
                default -> "-1";
            };
            case "N3" -> switch (ch) {
                case '0','1','2','3','4','5','6','7','8','9' -> "N3";
                case ' ' -> "U1";
                default -> "-1";
            };
            case "U1" -> switch (ch) {
                case 'E' -> "U2";
                default -> "-1";
            };
            case "U2" -> switch (ch) {
                case 'U' -> "E";
                default -> "-1";
            };
            default -> "-1";
        };
    }

    public boolean testString(String s) {
        state = "S";
        for(int i = 0; i < s.length(); i++) {
            state = this.consume(s.charAt(i));
        }
        return state.equals("E");
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.testString("D BW 23345 EU"));
        System.out.println(main.testString("DE-BY 233 EU"));
        System.out.println(main.testString("DK BY 233 EU"));
    }

}
