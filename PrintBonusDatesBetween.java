import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class PrintBonusDatesBetween {

  public static void main(String[] args) {
    printBonusDatesBetween(2000, 2100);
  }

  static void printBonusDatesBetween(int fromYear, int toYear) {

    // --- INITIAL INPUT СHECKS:
    // Specifying allowed years range:
    if ((fromYear < 1000 || fromYear > 9999) || (toYear < 1000 || toYear > 9999)) {
      System.out
          .println("\n NOT ALLOWED: Please note that years cannot be smaller than 1000 and bigger than 9999 \n");
      return;
    }

    // Sense-checking whether starting year is not bigger than ending year:
    if (toYear < fromYear) {
      System.out.println("\n NOT ALLOWED: Please note that starting year cannot be bigger than ending year \n");
      return;
    }

    // --- DATA PREPARATION & FORMATTING:
    // Date formating pattern for dates:
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Setting starting date by adding first day and month of the year:
    LocalDate fromYearDate = LocalDate.of(fromYear, Month.JANUARY, 1);

    // Setting ending date by adding last day and month of the year:
    LocalDate toYearDate = LocalDate.of(toYear, Month.DECEMBER, 31);

    // --- CHECKING THE DATES AND OUTPUTING RESULTS:
    // Palindrome dates checking mechanism:
    for (LocalDate iteratingDate = fromYearDate; (iteratingDate.isBefore(toYearDate)
        || iteratingDate.isEqual(toYearDate)); iteratingDate = iteratingDate.plusDays(1)) {
      String dateString = iteratingDate.format(formatter);
      String formatedDateString = dateString.replace("-", "");

      // (Re)Setting the amount of matches:
      int matches = 0;

      // The loop below compares the first digit of the date equals the last digit of the date, second equals second form the end and so on. If there is a match, then the "matches" variable is incremented: 
      for (int i = 0, j = formatedDateString.length() - 1; i < formatedDateString.length() / 2; i++, j--) {

        if (formatedDateString.charAt(i) == formatedDateString.charAt(j)) {
          matches++;
        }

      }

      // If there are 4 matches, it means that the date can be effectivelly reversed and still show the same date. In such case we're printing the date:
      if (matches == 4)
        System.out.println(dateString);
    }
  }
}