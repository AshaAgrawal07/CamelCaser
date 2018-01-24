public class CamelCaser {
    public static String camelCase(String inputString) throws IllegalArgumentException {

        //first check if null
        if(inputString == null || inputString.trim().length() == 0) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_INPUT);
        }

        String camelCasedResult = "";
        String inputRevised = inputString.toLowerCase().trim();

        String[] splittedInputString = inputRevised.split(" +");

        for(int i = 0; i < splittedInputString.length; i++) {

            //first check that there is atleast 1 valid letter in the string
            if(splittedInputString[i].matches("[^a-zA-Z]")) {
                if(splittedInputString[i].equals(" ")) {
                    i++;
                    break;
                } else if (splittedInputString[i].matches("[\\d]")){
                    throw new IllegalArgumentException(ErrorConstants.INVALID_FORMAT);
                } else {
                    throw new IllegalArgumentException(ErrorConstants.INVALID_CHARACTER);
                }
            }

            //check that the first char of the word is a digit
            if(splittedInputString[i].substring(0,1).matches("[\\d]")) {
                throw new IllegalArgumentException(ErrorConstants.INVALID_FORMAT);
            }

            //check that there aren't any invalid characters in the word
            if(splittedInputString[i].split("[^a-zA-Z0-9]").length > 1) {
                throw new IllegalArgumentException(ErrorConstants.INVALID_CHARACTER);
            }

            //check that the "word" is not an excess space and that its not the first word
            if (!splittedInputString[i].equals(" ") && i != 0) {
                camelCasedResult += (splittedInputString[i].substring(0, 1).toUpperCase() + splittedInputString[i].substring(1));
            }

            if (i == 0) {
                camelCasedResult += splittedInputString[i];
            }
        }
        return camelCasedResult;
    }
}
