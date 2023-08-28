import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PrintBonusDatesBetween {

  public static void main(String[] args) {
    PrintBonusDatesBetween(2010, 2015);
  }

  static void PrintBonusDatesBetween(int fromYear, int toYear) {
    // Date formating pattern:
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    // Setting starting date:
    Calendar fromYearDate = Calendar.getInstance();
    fromYearDate.set(fromYear, 0, 1);

    // Setting ending date:
    Calendar toYearDate = Calendar.getInstance();
    toYearDate.set(toYear, 11, 31);

    // Palindrome dates checking mechanism:
    for (Calendar iteratingDate = fromYearDate; (iteratingDate.before(toYearDate)
        || iteratingDate.equals(toYearDate)); iteratingDate.add(Calendar.DATE, 1)) {
      String dateString = sdf.format(iteratingDate.getTime()).toString();
      String formatedDateString = dateString.replace("-", "");

      // (Re)Setting the amount of matches:
      int matches = 0;

      // The loop below compares the first number of the date equals the last number of the date, second equals second form the end and so on. If the is a match, then the "matches" variable is incremented: 
      for (int i = 0, j = formatedDateString.length() - 1; i < formatedDateString.length() / 2; i++, j--) {

        if (formatedDateString.charAt(i) == formatedDateString.charAt(j)) {
          matches++;
        }

      }

      // If there are 4 matches, it means that the date  can be effectivelly reversed and still show the same date. In such case we're printing the date:
      if (matches == 4)
        System.out.println(dateString);
    }
  }
}