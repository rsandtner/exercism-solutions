class IsbnVerifier {

    boolean isValid(String isbn) {

        var cleaned = isbn.replace("-", "");
        if (cleaned.length() != 10) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {

        var c = cleaned.charAt(i);
        if (Character.isDigit(c)) {
        sum += Character.getNumericValue(c) * (10 - i);
        continue;
        }

        if (i < 9 || c != 'X') {
        return false;
        }

        sum += 10;
        }


        return sum % 11 == 0;
    }

}
