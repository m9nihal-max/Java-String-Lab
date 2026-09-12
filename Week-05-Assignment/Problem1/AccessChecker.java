public class AccessChecker {

    public static String classifyAccess(String fieldModifier, String accessorContext) {

        if (fieldModifier.equals("private")) {
            return accessorContext.equals("SAME_CLASS")
                    ? "ALLOWED"
                    : "DENIED";
        }

        if (fieldModifier.equals("default")) {
            return accessorContext.equals("SAME_CLASS")
                    || accessorContext.equals("SAME_PACKAGE")
                    ? "ALLOWED"
                    : "DENIED";
        }

        if (fieldModifier.equals("protected")) {
            return accessorContext.equals("SAME_CLASS")
                    || accessorContext.equals("SAME_PACKAGE")
                    ? "ALLOWED"
                    : "DENIED";
        }

        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }

        return "DENIED";
    }

    public static String summarizeByModifier(String[][] attempts) {

        String[] modifiers = {"private", "default", "protected", "public"};

        int[] allowed = new int[4];
        int[] denied = new int[4];

        for (String[] attempt : attempts) {

            String modifier = attempt[0];
            String context = attempt[1];

            String result = classifyAccess(modifier, context);

            int index = -1;

            for (int i = 0; i < modifiers.length; i++) {
                if (modifiers[i].equals(modifier)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                if (result.equals("ALLOWED")) {
                    allowed[index]++;
                } else {
                    denied[index]++;
                }
            }
        }

        return "private: " + allowed[0] + " allowed / " + denied[0] + " denied"
                + " | default: " + allowed[1] + " allowed / " + denied[1] + " denied"
                + " | protected: " + allowed[2] + " allowed / " + denied[2] + " denied"
                + " | public: " + allowed[3] + " allowed / " + denied[3] + " denied";
    }
}
