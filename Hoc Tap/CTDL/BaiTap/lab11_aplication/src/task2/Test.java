package task2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chapter chapter_1 = new Chapter("Chuong 1", 25);
		Chapter chapter_2 = new Chapter("Chuong 2", 16);
		Chapter chapter_3 = new Chapter("Chuong 3", 18);

		List<Chapter> list_chapter_1 = Arrays.asList(chapter_2, chapter_3);
		List<Chapter> list_chapter_2 = Arrays.asList(chapter_1, chapter_2);

		Reference reference_1 = new Reference("Sach 1", 2022, "Nguyen Khai Nam", 20, "Hai kich", list_chapter_1);
		Reference reference_2 = new Reference("Sach 2", 2022, "Nguyen Thi Kim Ngan", 200, "Trinh Tham", list_chapter_2);

		Magezine magezine_1 = new Magezine("Tap chi 1", 25, 1999, "Nguyen Van A", 10);
		Magezine magezine_2 = new Magezine("Tap chi 2", 20, 1999, "Nguyen Van A", 5);

		List<Book> list_book = Arrays.asList(reference_1, reference_2, magezine_1, magezine_2);

		Category category = new Category(list_book);

		System.out.println("Cau 1a: " + reference_1.type());
		System.out.println("Cau 1b: " + magezine_1.type());

		System.out.println("------------------------------------");

		System.out.println("Cau 2a: " + magezine_1.oldMagezine(10));
		System.out.println("Cau 2b: " + reference_1.oldMagezine(8));
		System.out.println("Cau 2c: " + magezine_2.oldMagezine(9));

		System.out.println("------------------------------------");

		System.out.println("Cau 3a: " + magezine_1.sameTypeAndAuthor(magezine_2));
		System.out.println("Cau 3b: " + magezine_1.sameTypeAndAuthor(reference_1));

		System.out.println("------------------------------------");

		System.out.println("Cau 4: " + category.sumPrice());

		System.out.println("------------------------------------");

		System.out.println("Cau 5: " + category.maxPageChapter());

		System.out.println("------------------------------------");

		System.out.println("Cau 6: " + category.hasMagezine("Tap chi 2"));

		System.out.println("------------------------------------");

		System.out.println("Cau 7: " + category.magezineYearAgo(2));

		System.out.println("------------------------------------");

		System.out.println("Cau 8: " + category.sort(new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				// TODO Auto-generated method stub
				int rangeTitle = o1.getTitle().compareTo(o2.getTitle());
				return rangeTitle == 0? o2.getYear() - o1.getYear() : rangeTitle;
			}
		}).toString());
		
		System.out.println("------------------------------------");
		
		System.out.println("Cau 9: " + category.statisticsByYear());

	}

}
