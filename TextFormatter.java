import java.util.StringTokenizer;

class TextFormatter {
  private int maxLineLength = 0;

  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
          "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
          "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
          "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod " +
          "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
          "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est " +
          "Lorem ipsum dolor sit amet.";

  public static void main(String[] args) {
    TextFormatter formatter = new TextFormatter(30);
    formatter.print(text);
  }

  // Konstruktor
  public TextFormatter(int newMaxLineLength) {
    maxLineLength = newMaxLineLength;
  }

  // Ausgabe
  public void print(String aText) {
    String formattedText = formatRightBound(aText);

    System.out.println(formattedText);
  }

  private String formatLeftBound(String aText) {
    StringTokenizer st1 =  new StringTokenizer(text, " "); 
    String formattedText = "";
    String line = "";

    while (st1.hasMoreTokens()) 
    { 
      String nextWord = st1.nextToken();
      // if the line + nextWord is longer than maxLineLength, create a new line 
      // for nextWord. The current line is thus complete and added to formattedText.
      if((line.length() + nextWord.length()) > maxLineLength){
        formattedText += line + "\n";
        line = "";
      }
      line += nextWord + " "; 
    }
     
    formattedText += line;

    return formattedText;
  }


  private String formatRightBound(String aText) {
    StringTokenizer st1 =  new StringTokenizer(text, " "); 
    String formattedText = "";
    String line = "";

    while (st1.hasMoreTokens()) 
    { 
      String nextWord = st1.nextToken();
      // if the line + nextWord is longer than maxLineLength, create a new line 
      // for nextWord. The current line is thus complete and added to formattedText.
      if((line.length() + nextWord.length()) > maxLineLength){

        // pads the line with spaces so the line lenght matches maxLineLength
        if(line.length() < maxLineLength)
        {
          //  str.append("point");
          int amount = maxLineLength - line.length();
          String padding = "";
          for(int i = 0; i < amount; i++) 
          {
            padding += " ";
          }
          line = padding + line;
        
        }

        formattedText += line + "\n";
        line = "";
      }
      line += nextWord + " "; 
    }
     
    formattedText += line;

    return formattedText;
  }
}