import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
	public static void main(String[] args) {
		List<Integer> lst = new LinkedList<>();
		ListIterator<Integer> lstIterator = lst.listIterator();

		while (lstIterator.hasNext()) {
			System.out.println(lstIterator.next());
		}

		Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
		ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(arr);

		System.out.println(arrayIterator.hasNext());
		System.out.println(arrayIterator.hasNext());
		System.out.println(arrayIterator.hasNext());
		System.out.println(arrayIterator.hasNext());
		System.out.println(arrayIterator.hasNext());
		while (arrayIterator.hasNext()) {
			System.out.println(arrayIterator.next());
		}
		//arrayIterator.next();


		// Date
		Date date = new Date();
		System.out.println(date);

		Date date2 = new Date(110, Calendar.MARCH, 30);
		System.out.println(date2);
		System.out.println(date.before(date2));


		// LocalDate
		LocalDate now = LocalDate.now();
		System.out.println(now);

		DayOfWeek day = now.getDayOfWeek();
		System.out.println(day);


		// LocalTime
		LocalTime now2 = LocalTime.now();
		System.out.println(now2);
		now2 = now2.plusMinutes(100);
		now2 = now2.minus(Duration.ofHours(3));
		System.out.println(now2);

		LocalDateTime now4 = LocalDateTime.now();
		System.out.println(now4);

		LocalDateTime someDate = LocalDateTime.of(2001, 10, 10, 15, 15);
		System.out.println(someDate);


		//	Вывести на экран 10 случайных дат созданных с помощью конструктора LocalDate от (2000 до 2022)
		//	Выводить  в формате “(10/Jan/2005:Mon)” и воспользоваться DateTimeFormatter
		//	К каждой дате добавить 1 день и вывести день недели который получился
		for (int i = 0; i < 10; i++) {
			int year = (int) (Math.random() * 22 + 2000);
			int day1 = (int) (Math.random() * 28 + 1);
			int month = (int) (Math.random() * 12 + 1);

			LocalDate localDate = LocalDate.of(year, month, day1);
			System.out.println(localDate.format(DateTimeFormatter.ofPattern("(dd/MMM/yyyy:EEE)")));
			System.out.println("Next day of week: " + localDate.plusDays(1).getDayOfWeek());
			System.out.println();
		}



		// plus/minus localDate
		LocalDate now3 = LocalDate.now();
		System.out.println(now3.minusWeeks(1));
		System.out.println(now3.minusMonths(1));
		System.out.println(now3.minus(1, ChronoUnit.CENTURIES));



		// Comparing of dates
		LocalDateTime now5 = LocalDateTime.now();
		System.out.println(now5.plusWeeks(11));
		System.out.println(now5.plusSeconds(1000));
		System.out.println(now5.plusHours(2));
		LocalDateTime twoWeeksLater = now5;

		System.out.println(now5.isAfter(twoWeeksLater));
		System.out.println(now5.isBefore(twoWeeksLater));
		System.out.println(now5.compareTo(twoWeeksLater));



		// Instant
		Instant time = Instant.now();
		System.out.println(Instant.EPOCH);
		System.out.println(Instant.MAX);
		System.out.println(Instant.MIN);

		Instant oneHourLater = time.plusSeconds(3600);
		System.out.println(time);
		System.out.println(oneHourLater);
		System.out.println(time.isAfter(oneHourLater));



		// ZonedId
		ZoneId zoneId = ZoneId.of("Japan");
		ZonedDateTime zonedDateTimeAsia = ZonedDateTime.of(LocalDateTime.now(zoneId), zoneId);
		System.out.println(zonedDateTimeAsia);

		ZonedDateTime kiev = zonedDateTimeAsia.withZoneSameInstant(ZoneOffset.of("+02:00"));
		System.out.println(kiev);

		System.out.println(ZoneId.getAvailableZoneIds());



		// 2002-12-31
		// Parsing of date
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String str = "2002-12-31";


		try {
			Date date1 = format.parse(str);
			System.out.println(date1);
		} catch (ParseException e) {
			System.out.println("Bad input");
		}
		System.out.println("Continue working");


		// Parsing of LocalDate
		String str2 = "2002-12-31";
		LocalDate date3 = LocalDate.parse(str2, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println(date3);

	}
}