package database;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import model.account.Account;
import model.function.FunctionImg;
import model.info.Address;
import model.info.Date;
import model.info.EnumPosition;
import model.info.EnumPositionStaff;
import model.info.EnumStatusType;
import model.info.EnumTypeMovie;
import model.management.manager.Manager;
import model.management.staff.Staff;
import model.management.staff.Work;
import model.movie.Actor;
import model.movie.Author;
import model.movie.InfoMovie;
import model.movie.Movie;
import model.movie.ShowTime;

/**
 * Database giả lập
 */
public class Database {
	// Xác định xem đã được khởi tạo chưa
	private static boolean correct = false;

	// Đường dẫn thư mục ảnh
	private static String pathImg = "img/";

	// Ánh xạ từng thư mục chứa ảnh
	private static Map<String, List<Image>> mapImg = new HashMap<>();

	// Các nhân viên đã được lưu vào hệ thống
	private static List<Staff> staffs = new ArrayList<>();

	// Các quản lý trong hệ thống
	private static List<Manager> managers = new ArrayList<>();

	// Tài khoản ứng với mỗi nhân viên
	private static Map<String, Account> mapAccounts = new HashMap<>();

	// Các bộ phim có trong hệ thông
	private static List<InfoMovie> infoMovies = new ArrayList<>();

	/**
	 * @return the correct
	 */
	public static boolean isCorrect() {
		return correct;
	}

	/**
	 * @return the mapImg
	 */
	public static Map<String, List<Image>> getMapImg() {
		return mapImg;
	}

	/**
	 * @return the mapAccounts
	 */
	public static Map<String, Account> getMapAccounts() {
		return mapAccounts;
	}

	/**
	 * @return the staffs
	 */
	public static List<Staff> getStaffs() {
		return staffs;
	}

	/**
	 * @return the managers
	 */
	public static List<Manager> getManagers() {
		return managers;
	}

	/**
	 * @return the infoMovies
	 */
	public static List<InfoMovie> getInfoMovies() {
		return infoMovies;
	}

	public Database() {
		createDataTest();
	}

	/**
	 * Khởi tạo dữ liệu để test, phải để đúng thứ tự, bởi vì các phần tử khởi tạo
	 * sau createImg cần thông tin từ nó
	 */
	private void createDataTest() {
		// TODO Auto-generated method stub
		correct = true;
		createImg();
		createStaffs();
		createManagers();
		createAccounts();
		createMovies();
	}

	// Tạo các bộ phim
	private void createMovies() {
		// TODO Auto-generated method stub
		List<Image> imgsMovies = mapImg.get("movie");

		// Cho là đồng giá
		double price = 50;

		int id = 0;

		Movie m1 = new Movie(imgsMovies.get(0), "All Quiet On The Western Front", price, EnumTypeMovie.War,
				"In the West, it is not unusual to see an epic-war-drama film premiered in 2022 by Germany and the United States, based on the novel of the same name by writer Erich Maria Remarque.",
				new Date(29, 9, 2022), Arrays.asList(new Author("Edward Berger", 53)), Arrays.asList("Sven Budelmann"),
				Arrays.asList("Netflix"),
				Arrays.asList(new Actor("Daniel Brühl", 44), new Actor("Felix Kammerer", 27),
						new Actor("Albrecht Schuch", 37), new Actor("Aaron Hilmer", 23)),
				Arrays.asList("Germany", "France", "English"),
				"All Quiet on the Western Front (German: Im Westen nichts Neues) is a German-U.S. film from 2022 based on the novel of the same name by Erich Maria Remarque. The film is written and directed by Edward Berger, with actors including Felix Kammerer, Albrecht Schuch and Daniel Brühl. The film follows Paul Bäumer, a young German soldier who joined the Western Front during World War I, and here he has noticed the harsh realities of the war, from which he hopes to survive that war in order to be able to return.");
		List<ShowTime> s1 = Arrays.asList(new ShowTime(8, 0, 0, new Date(2, 2, 2023)),
				new ShowTime(9, 30, 0, new Date(2, 2, 2023)));
		InfoMovie i1 = new InfoMovie(id++ + "", m1, s1);

		Movie m2 = new Movie(imgsMovies.get(1), "Peninsula", price, EnumTypeMovie.Horror,
				"The Peninsula is a South Korean post-apocalyptic survival horror action film that premiere in 2020, written and directed by Yeon Sang-ho. The film stars Kang Dong-won, Lee Jung-hyun and Lee Re.",
				new Date(15, 7, 2020), Arrays.asList(new Author("Yeon Sang-ho", 44)), Arrays.asList("Yang Jin-mo"),
				Arrays.asList("Next Entertainment World", " RedPeter Film", " New Movie"),
				Arrays.asList(new Actor("Kim Soo-Ahn", 5), new Actor("Kang Dong-won", 42), new Actor("Lee Re", 17),
						new Actor("Ma Dong-seok", 52)),
				Arrays.asList("Korean", "English", "Guangzhou"),
				"The film takes place four years after the Busan disaster but begins with the main character, USFK Marine Captain Han Jung-seok, driving his family and sister to the port, the government and the country are now on the verge of complete collapse due to the pandemic and this is the last military train for refugees. On the way to Jung-seok, he met Min-jung, a mother who begged him to help his family, but fearing that the other family would be infected and being late on board, he decided to leave them.\r\n"
						+ "\r\n"
						+ "Jung-seok took her sister’s family onto a refugee boat to Japan but then the boat suddenly shifted to Hong Kong because the Japanese government was unable to accept more refugees. Suddenly, in the same room where Jung-seok’s sister and nephew were staying, there was a man who became infected and turned into a ghost. When Jung-seok arrives at the check-up, he discovers that his nephew has been infected and beside his sister is crying for him, Jung-Seok and his brother-in-law Goo Chul-min want to save her sister but fail. Eventually, both his sister and grandson died. This is the event in 2016, taking place at the same time as the movie Death Train.");
		List<ShowTime> s2 = Arrays.asList(new ShowTime(8, 30, 0, new Date(2, 2, 2023)),
				new ShowTime(9, 45, 0, new Date(3, 4, 2023)));
		InfoMovie i2 = new InfoMovie(id++ + "", m2, s2);

		Movie m3 = new Movie(imgsMovies.get(2), "The Batman (2022)", price, EnumTypeMovie.Action_Movie,
				"The Batman: The Truth is an American superhero-themed film, based on the character of the same name in the DC Comics series.",
				new Date(4, 3, 2022), Arrays.asList(new Author("Matt Reeves", 57)),
				Arrays.asList("Matt Reeves", "Peter Craig"),
				Arrays.asList("DC Films", "6th & Idaho", "Dylan Clark Productions"),
				Arrays.asList(new Actor("Robert Pattinson", 36), new Actor("Zoë Kravitz", 34),
						new Actor("Paul Dano", 38), new Actor("Colin Farrell", 46)),
				Arrays.asList("English"),
				"On Halloween, in Gotham City, Mayor Don Mitchell Jr. is murdered by a serial killer who calls himself Riddler. Billionaire Bruce Wayne, who then spent two years as Batman punishing criminals, investigates with Gotham City Police Department. (GCPD). Lt. James Gordon discovers that Riddler left a message to Batman, but Commissioner Pete Savage blamed him for allowing Batman to enter the scene and forcing him to leave. Riddler kills Savage, leaves another message to Batman and sends a video of Savage’s death to the media.");
		List<ShowTime> s3 = Arrays.asList(new ShowTime(10, 30, 0, new Date(6, 3, 2023)),
				new ShowTime(13, 45, 0, new Date(13, 4, 2023)));
		InfoMovie i3 = new InfoMovie(id++ + "", m3, s3);

		Movie m4 = new Movie(imgsMovies.get(3), "Black Adam", price, EnumTypeMovie.Action_Movie,
				"Black Adam is an American superhero film released in 2022, based on the DC Comics character of the same name. Produced by New Line Cinema, DC Films, Seven Bucks Productions and Flynn Picture, it is a spinoff from Shazam!, and the 11th film in the DC Extended Universe.",
				new Date(21, 10, 2022), Arrays.asList(new Author("Jaume Collet-Serra", 49)),
				Arrays.asList("Adam Sztykiel", "Rory Haines", "Sohrab Noshirvani"),
				Arrays.asList("New Line Cinema", "DC Films", "Seven Bucks Productions", "FlynnPictureCo"),
				Arrays.asList(new Actor("Dwayne Johnson", 50), new Actor("Sarah Shahi", 43),
						new Actor("Henry Cavill", 39), new Actor("Noah Centineo", 26)),
				Arrays.asList("English"),
				"In 2600 BC, the tyrannical king of Kahndaq, Ahk-Ton, created the Crown of Sabbac, which could grant great power to his master. After attempting to organize an uprising, a slave boy was granted the power of Shazam, he became the heroic champion of Kahndaq, he killed Ahk-Ton and ended his reign.\r\n"
						+ "\r\n"
						+ "In modern times, Kahndaq is ruled by the Intergang. Archaeologist Adrianna Tomaz attempts to locate Sabbac's Crown with the help of her brother Karim and colleagues, Samir and Ishmael Gregor. When Adrianna obtained the crown, they were surrounded by Intergang. Adrianna recited a spell that awakened Teth-Adam, whom she believed to be the champion of Kahndaq, from his tomb. Adam then killed most of the Intergang army.");
		List<ShowTime> s4 = Arrays.asList(new ShowTime(10, 30, 0, new Date(16, 3, 2023)),
				new ShowTime(14, 50, 0, new Date(23, 4, 2023)));
		InfoMovie i4 = new InfoMovie(id++ + "", m4, s4);

		Movie m5 = new Movie(imgsMovies.get(4), "Black Widow", price, EnumTypeMovie.Action_Movie,
				"Black Widow is an American superhero film based on the Marvel Comics character of the same name, produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures. Black Widow is the 24th film that opens Phase 4 in the Marvel Cinematic Universe.",
				new Date(9, 7, 2021), Arrays.asList(new Author("Cate Shortland", 54)), Arrays.asList("Eric Pearson"),
				Arrays.asList("Marvel Studios"), Arrays.asList(new Actor("Scarlett Johansson", 38),
						new Actor("Florence Pugh", 27), new Actor("Rachel Weisz", 53), new Actor("David Harbour", 48)),
				Arrays.asList("English"),
				"The event takes place right after Captain America: Civil War,[1] when Natasha Romanoff begins to find out about her true self.\r\n"
						+ "\r\n"
						+ "The film tells the tragic past of two sisters Natasha Romanoff and Yelena Belova (later played by Scarlett Johansson and Florence Pugh). Because of the separation of their families, the two later attended the Red Room's special training and became mighty warriors officially known as the Black Widow. As the most dangerous assassins in the world, sisters Natasha and Yelena struggle in the quagmire of memories and try to get out of it to rebuild their lives. At that time, the mercenary Task Master (with the ability to copy his opponent's moves) was hired to kill opposing Avengers members (including Steve Rogers, Natasha Romanoff, Wanda Maximoff, and Bucky Barnes), and His first target was Natasha Romanoff.");
		List<ShowTime> s5 = Arrays.asList(new ShowTime(9, 30, 0, new Date(16, 3, 2023)),
				new ShowTime(15, 30, 0, new Date(26, 4, 2023)));
		InfoMovie i5 = new InfoMovie(id++ + "", m5, s5);

		Movie m6 = new Movie(imgsMovies.get(5), "Captain Marvel", price, EnumTypeMovie.Science_Fiction,
				"Captain Marvel is a 2019 American superhero film based on the Marvel Comics character Carol Danvers. Produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures, the work is the 21st film in the Marvel Cinematic Universe.",
				new Date(7, 3, 2019), Arrays.asList(new Author("Anna Boden", 43), new Author("Ryan Fleck", 46)),
				Arrays.asList("Nicole Perlman", "Meg LeFauve", "Anna Boden", "Ryan Fleck", "Geneva Robertson-Dworet"),
				Arrays.asList("Marvel Studios"), Arrays.asList(new Actor("Brie Larson", 33),
						new Actor("Samuel L. Jackson", 74), new Actor("Gemma Chan", 40), new Actor("Jude Law", 50)),
				Arrays.asList("English"),
				"Since ancient times, the Kree and Skrulls have fought a long war, called the Kree–Skrull War. With the development of technology, the Kree gradually overwhelmed the war and caused the number of Skrulls to be significantly reduced.\r\n"
						+ "\r\n"
						+ "In 1995, Vers awoke in Hala, home of the Kree Empire. She always has nightmares about a plane crash, and about a woman being murdered in front of her. Her memory stops at the moment she gains her powers. She is trained by Yon-Rogg, the leader of Starforce, to become a member of the team. Although Yon-Rogg believes she is ready, the Supreme Intelligence, an artificial intelligence that runs the Kree Empire, refuses to let her join the team, where Minn-Erva, a sniper, and the rest of the crew. associates Korath, Bron-Char and Att-Lass.");
		List<ShowTime> s6 = Arrays.asList(new ShowTime(8, 45, 0, new Date(1, 2, 2023)),
				new ShowTime(17, 0, 0, new Date(3, 4, 2023)));
		InfoMovie i6 = new InfoMovie(id++ + "", m6, s6);

		Movie m7 = new Movie(imgsMovies.get(6), "Everything Everywhere All at Once", price,
				EnumTypeMovie.Science_Fiction,
				"Multiverse War is a 2022 United States martial arts action-drama comedy film written, directed, and co-produced by Daniel Kwan and Daniel Scheinert with the Russo brothers.",
				new Date(24, 6, 2022), Arrays.asList(new Author("Daniel Kwan", 35), new Author("Daniel Scheinert", 35)),
				Arrays.asList("Daniel Kwan", "Daniel Scheinert"),
				Arrays.asList("Daniel Kwan", "Daniel Scheinert", "Jonathan Wang", "Mike Larocca", "Joe Russo",
						"Anthony Russo"),
				Arrays.asList(new Actor("Dương Tử Quỳnh", 60), new Actor("Jamie Lee Curtis", 64),
						new Actor("Quan Kế Huy", 51), new Actor("Stephanie Hsu", 32)),
				Arrays.asList("English", "Mandarin", "Chinese"),
				"The film revolves around Evelyn Wang (Yang Ziqiong), a Chinese immigrant woman, a laundromat owner who has many problems in life. While meeting tax officer Deirdre Beaubeirdre (Jamie Lee Curtis) to settle finances, Evelyn accidentally meets another version of her husband Waymond (Guan Ke Hui) from the Alpha universe. He says she is the only version of Evelyn who can stop Jobu Topaki, the villain who wants to destroy the peace of the multiverse. Evelyn must learn to travel across worlds, using all the skills the other versions have to fight evil.");
		List<ShowTime> s7 = Arrays.asList(new ShowTime(12, 45, 0, new Date(23, 3, 2023)),
				new ShowTime(18, 15, 0, new Date(1, 4, 2023)));
		InfoMovie i7 = new InfoMovie(id++ + "", m7, s7);

		Movie m8 = new Movie(imgsMovies.get(7), "Dune", price, EnumTypeMovie.Science_Fiction,
				"Dune: Sand Planet is a 2021 American science fiction epic film directed and co-produced by Denis Villeneuve with a screenplay written by him, with Jon Spaihts and Eric Roth.",
				new Date(22, 10, 2021), Arrays.asList(new Author("Denis Villeneuve", 55)),
				Arrays.asList("Jon Spaihts", "Denis Villeneuve", "Eric Roth"), Arrays.asList("Legendary Pictures"),
				Arrays.asList(new Actor("Timothée Chalamet", 27), new Actor("Zendaya", 26),
						new Actor("Rebecca Ferguson", 39), new Actor("Oscar Isaac", 44)),
				Arrays.asList("English"),
				"In the distant future, Duke Leto of House Atreides - ruler of the ocean planet Caladan - has been commissioned by Emperor Padishah Shaddam Corrino IV to replace House Harkonnen as ruler of Arrakis as fiefdom. Arrakis is an inhospitable desert planet and the sole source of \"herb\", a precious resource with the ability to prolong life and raise consciousness. The substance is important for space travel because it allows the Space Society's pilots to use a limited amount of consciousness to safely steer their spacecraft. In reality, Shaddam intends for House Harkonnen to stage a coup to retake the planet with the help of the Emperor's Sardaukar army, destroying House Atreides, whose influence threatens domination. by Shaddam. Leto, though frightened, saw the political advantage of controlling the spice planet and formed an alliance with the native inhabitants of Arakis - skilled warriors known as Fremen.");
		List<ShowTime> s8 = Arrays.asList(new ShowTime(13, 45, 0, new Date(3, 3, 2023)),
				new ShowTime(19, 15, 0, new Date(2, 4, 2023)));
		InfoMovie i8 = new InfoMovie(id++ + "", m8, s8);

		Movie m9 = new Movie(imgsMovies.get(8), "Encanto", price, EnumTypeMovie.Cartoon,
				"Encanto: Wonderland is a 2021 musical-fantasy computer-animated film, produced by Walt Disney Animation Studios and distributed by Walt Disney Studios Motion Pictures, it is the 60th film. produced by the Walt Disney Company.",
				new Date(24, 11, 2021), Arrays.asList(new Author("Byron Howard", 54), new Author("Jared Bush", 48)),
				Arrays.asList("Charise Castro Smith", "Jared Bush"),
				Arrays.asList("Walt Disney Studios", "Motion Pictures"),
				Arrays.asList(new Actor("Stephanie Beatriz", 42), new Actor("John Leguizamo", 62),
						new Actor("Wilmer Valderrama", 43), new Actor("Sarah-Nicole Robles", 31)),
				Arrays.asList("English", "Spanish"),
				"An armed conflict[note 1] forces young couple Pedro and Alma Madrigal with their triplets (Julieta, Pepa and Bruno) to flee their home village in Colombia. The attackers kill Pedro, but Alma's candle suddenly magically blows them away and creates a sentient house called Casita, and high mountains rise around the magical land of Encanto.\r\n"
						+ "\r\n"
						+ "Fifty years later, a new village has flourished under the protection of the candle. The magic it bestows upon each descendant of the Madrigal family at the age of five is used to serve the common good of the community. Ten years earlier, Bruno Madrigal, who was vilified and scorned by his magic to see into the future, ran away from Encanto and at the same time, the mysterious 5-year-old Mirabel was not given a candle instead. miracle.");
		List<ShowTime> s9 = Arrays.asList(new ShowTime(9, 35, 0, new Date(23, 1, 2023)),
				new ShowTime(19, 15, 0, new Date(8, 4, 2023)));
		InfoMovie i9 = new InfoMovie(id++ + "", m9, s9);

		Movie m10 = new Movie(imgsMovies.get(9), "Eternal", price, EnumTypeMovie.Science_Fiction,
				"The Immortal Race is a 2021 American superhero film based on the Marvel Comics race of the same name. Produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures, it is the 26th film in the Marvel Cinematic Universe.",
				new Date(5, 11, 2021), Arrays.asList(new Author("Chloé Zhao", 41)),
				Arrays.asList("Chloé Zhao", "Patrick Burleigh", "Ryan Firpo", "Kaz Firpo"),
				Arrays.asList("Marvel Studios"),
				Arrays.asList(new Actor("Richard Madden", 36), new Actor("Harry Styles", 29),
						new Actor("Ma Dong-seok", 52), new Actor("Angelina Jolie", 47)),
				Arrays.asList("English"),
				"In 5000 BC, ten super-powered Eternals — Ajak, Sersi, Ikaris, Kingo, Sprite, Phastos, Makkari, Druig, Gilgamesh, and Thena — were sent to Earth by Celestial Arishem on their starship, the Domo, to destroy them. Deviants invaders. The last of the Deviants were apparently killed in 1521, when the group's opinions differed about their continued relationship with humanity. For the next five hundred years, they lived mostly apart, awaiting Arishem's orders.");
		List<ShowTime> s10 = Arrays.asList(new ShowTime(9, 35, 0, new Date(23, 1, 2023)),
				new ShowTime(19, 15, 0, new Date(8, 4, 2023)));
		InfoMovie i10 = new InfoMovie(id++ + "", m10, s10);

		Movie m11 = new Movie(imgsMovies.get(10), "Fast & Furious 9", price, EnumTypeMovie.Action_Movie,
				"Fast & Furious 9: Legend of Speed ​​is a 2021 American action film directed by Lam Nghe Bin and written by Daniel Casey. The sequel to 2017's The Fate of the Furious, it is the ninth installment of the main storyline in the The Fast Saga franchise and the tenth feature-length film released overall.",
				new Date(25, 6, 2021), Arrays.asList(new Author("Justin Lin", 51)),
				Arrays.asList("Daniel Casey", "Justin Lin"),
				Arrays.asList("Original Film", "One Race Films", "Roth/Kirschenbaum Films"),
				Arrays.asList(new Actor("Vin Diesel", 55), new Actor("Michelle Rodriguez", 44),
						new Actor("Jordana Brewster", 43), new Actor("John Cena", 46)),
				Arrays.asList("English"),
				"In 1989, Jack Toretto - father of 3 brothers Dom, Jakob and Mia - participated in the final race of the season, with his 2 sons on the maintenance team. In the technical area, while Jakob fixes his father's car, Dom argues with rival racer Kenny Linder, claiming he is playing dirty. Back in the race, Linder's car crashed into Jack's shock absorber, causing the car to catch on fire and he was killed. A week after the race, Linder went to Toretto's house under the pretext of showing respect to Jack, despite the fact that he wanted to tease Jack's two children. Dom beat him to death and went to jail. While serving his sentence, he recalls Jakob fixing his father's car on the day of his death and believes that his brother's negligence killed his father. When he was released, Dom found Jakob, now a notorious street racer. Two brothers drag each other into a race, at the cost that the loser will have to leave his hometown forever. The race ended with Dom's victory, and Jakob left the country right after the race, cutting off contact with everyone, keeping in touch only with the youngest sister Mia.");
		List<ShowTime> s11 = Arrays.asList(new ShowTime(9, 45, 0, new Date(23, 4, 2023)),
				new ShowTime(19, 20, 0, new Date(18, 1, 2023)));
		InfoMovie i11 = new InfoMovie(id++ + "", m11, s11);

		Movie m12 = new Movie(imgsMovies.get(11), "Gái già lắm chiêu V", price, EnumTypeMovie.Romance,
				"V: The Royal Life is a Vietnamese drama film in 2021 co-directed by Nam Cito and Bao Nhan. The work revolves around the story of 3 sisters Ly Le Ha, Ly Le Hong and Ly Linh. The Ly family lives in the luxurious Bach Tra Vien, full of antiques worth \"several times more than a supercar\".",
				new Date(5, 3, 2021), Arrays.asList(new Author("Bảo Nhân", 40), new Author("Nam Cito", 40)),
				Arrays.asList(""), Arrays.asList("Lotte Cinema", "Mar6 Pictures"),
				Arrays.asList(new Actor("Kaity Nguyễn", 24), new Actor("Lê Xuân Tiền", 27),
						new Actor("Ninh Dương Lan Ngọc", 33), new Actor("Lê Khanh", 59)),
				Arrays.asList("Vietnamese"),
				"At Bach Tra Vien villa in Hue, there are three sisters of the Ly family, who are famous for their rich antiques business. The eldest sister Ly Le Ha and her younger sister Ly Le Hong manage the family's antiques business, as well as devise tricks to buy and resell fake antiques to profit. Meanwhile, the youngest sister Ly Linh lives in Ho Chi Minh City, working for the real estate group of father and son Lam Quach. In Bach Tra Vien, there is also a curse that until the white tea garden blooms red, the Ly sisters can get married.\r\n"
						+ "\r\n"
						+ "During Ly Le Ha's auction, Ly Le Hong almost let the phoenix robe fall into Lam Quach's hands, but Le Ha returned in time, she blamed her sister for her carelessness. In the middle of the night, Le Ha stood in front of the phoenix robe, dazed with the aura it radiated.");
		List<ShowTime> s12 = Arrays.asList(new ShowTime(8, 45, 0, new Date(12, 1, 2023)),
				new ShowTime(19, 20, 0, new Date(12, 1, 2023)), new ShowTime(22, 0, 0, new Date(12, 1, 2023)));
		InfoMovie i12 = new InfoMovie(id++ + "", m12, s12);

		Movie m13 = new Movie(imgsMovies.get(12), "Avengers: Infinity War", price, EnumTypeMovie.Action_Movie,
				"Avengers: Infinity War is a 2018 American superhero film based on Marvel Comics characters.",
				new Date(27, 4, 2018), Arrays.asList(new Author("Anthony Russo", 53), new Author("Joe Russo", 51)),
				Arrays.asList("Kevin Feige"), Arrays.asList("Marvel Studios"),
				Arrays.asList(new Actor("Robert Downey Jr.", 58), new Actor("Josh Brolin", 55),
						new Actor("Scarlett Johansson", 38), new Actor("Chris Hemsworth", 39)),
				Arrays.asList("English"),
				"After obtaining the Power Stone, one of the six Infinity Stones from the planet Xandar, Thanos and his adopted children - Ebony Maw, Cull Obsidian, Proxima Midnight, and Corvus Glaive - attack the Statesman ship carrying the refugees. Asgardian disaster, killing half of the people here. Thanos tortures Thor to force Loki to hand over the Space Stone hidden in the Tesseract. Hulk tried to stop but was also quickly defeated by Thanos. Heimdall was barely able to use the power of the Bifröst Bridge to bring Hulk back to Earth, and he was discovered and killed by Thanos. Loki pretended to surrender to kill Thanos, only to end up with Heimdall. Thanos then destroyed the ship and let Thor drift into space.");
		List<ShowTime> s13 = Arrays.asList(new ShowTime(8, 45, 0, new Date(12, 3, 2023)),
				new ShowTime(19, 20, 0, new Date(12, 4, 2023)));
		InfoMovie i13 = new InfoMovie(id++ + "", m13, s13);

		Movie m14 = new Movie(imgsMovies.get(13), "John Wick: Chapter 3 – Parabellum", price,
				EnumTypeMovie.Action_Movie,
				"Assassin John Wick: Part 3 – Preparing for War is a 2019 American crime action film, starring Keanu Reeves as the title character in the third installment of the John Wick series. Assassin John Wick and Assassin John Wick: Part 2",
				new Date(17, 5, 2019), Arrays.asList(new Author("Chad Stahelski", 54)), Arrays.asList("Derek Kolstad"),
				Arrays.asList("Summit Entertainment", "Thunder Road Pictures", "87Eleven Productions"),
				Arrays.asList(new Actor("Keanu Reeves", 58), new Actor("Chad Stahelski", 54),
						new Actor("Halle Berry", 56), new Actor("Laurence Fishburne", 61)),
				Arrays.asList("English"),
				"Less than an hour after the end of the previous film, former assassin John Wick is currently being hunted and has to go on the run in Manhattan. After the murder of mafia boss Santino D'Antonio at the Continental New York hotel, John was sentenced to \"Dismissal\" and offered a reward of 14 million dollars. On his way to escape his killers, John stops at the New York Public Library to retrieve a cross necklace and a blood seal. He fought intensely, killing many assassins around the area until he met the Director, a woman he knew in the past, and she was running an assassin training school under the guise of a theater. She accepted the necklace of the cross and gave John a safe trip to Casablanca, Morocco, showing that he had exhausted all his privileges. Meanwhile, the Adjudicator, the judge of the Supreme Council, meets Winston, the manager of the Continental Hotel, and the Beggar King, the leader of a beggar intelligence network. The Adjudicator criticizes both for helping John Wick kill Santino D'Antonio, and both are given seven days to leave their homes or face serious consequences.");
		List<ShowTime> s14 = Arrays.asList(new ShowTime(9, 45, 0, new Date(12, 4, 2023)),
				new ShowTime(17, 20, 0, new Date(26, 4, 2023)));
		InfoMovie i14 = new InfoMovie(id++ + "", m14, s14);

		Movie m15 = new Movie(imgsMovies.get(14), "Gekijōban Kimetsu no Yaiba: Mugen Ressha-hen", price,
				EnumTypeMovie.Anime,
				"Demon Slayer: Endless Train is a 2020 Japanese theatrical anime film, based on Gotōge Koyoharu's Demon Slayer manga. It is the cinematic sequel to the 2019 anime series, directed by Sotozaki Haruo and produced by Ufotable.",
				new Date(11, 12, 2020), Arrays.asList(new Author("Haruo Sotozaki", 29)),
				Arrays.asList("Gotōge Koyoharu"), Arrays.asList("Ufotable"),
				Arrays.asList(new Actor("Matthew Mercer", 40), new Actor("Kaji Yūki", 37),
						new Actor("Okamoto Nobuhiko", 36), new Actor("Takuya Eguchi", 35)),
				Arrays.asList("Japanese"),
				"Kamado Tanjiro and friends from the Demon Slayer Team go with the Flame Pillar Rengoku Kyōjurō, to investigate a series of mysterious disappearances that occurred inside a train. Unbeknownst to them, Enmu, Xia Xuan Yi of the Twelve Moon Demons, was also on board and had set up a trap.");
		List<ShowTime> s15 = Arrays.asList(new ShowTime(11, 45, 0, new Date(19, 4, 2023)),
				new ShowTime(17, 10, 0, new Date(27, 4, 2023)));
		InfoMovie i15 = new InfoMovie(id++ + "", m15, s15);

		Movie m16 = new Movie(imgsMovies.get(15), "My Hero Academia: World Heroes' Mission", price, EnumTypeMovie.Anime,
				"Hero Academy: A Mission to Save the World is a 2021 Japanese animated superhero film, this is the third movie based on the popular manga series Superhero Academy by Kōhei Horikoshi",
				new Date(6, 8, 2021), Arrays.asList(new Author("Nagasaki Kenji", 51)), Arrays.asList("Yōsuke Kuroda"),
				Arrays.asList("Bones"),
				Arrays.asList(new Actor("Ryan Colt Levy", 36), new Actor("Justin Briner", 31),
						new Actor("Yūki Aoi", 31), new Actor("Cristina Vee", 35)),
				Arrays.asList("Japanese"),
				"A group of capable opponents has destroyed a city by releasing a gas, causing all the powers of its inhabitants to spiral out of control, the greatest heroes of the world. Japan has scattered around the world to find the leader and bring him to justice. As part of Team Endeavor, Deku, Bakugo and Todoroki travel to the European country of Otheon. But after stopping an unsuccessful robbery, Deku is unwittingly accused of serial murder and is on the run with a criminal, with the police and the terrorists on the run. me.");
		List<ShowTime> s16 = Arrays.asList(new ShowTime(14, 35, 0, new Date(21, 4, 2023)),
				new ShowTime(18, 0, 0, new Date(22, 4, 2023)));
		InfoMovie i16 = new InfoMovie(id++ + "", m16, s16);

		Movie m17 = new Movie(imgsMovies.get(16), "Bullet Train", price, EnumTypeMovie.Action_Movie,
				"Bullet Train: Killer Confrontation is an American action comedy-crime film released in 2022 directed and produced by David Leitch, with a screenplay written by Zak Olkewicz based on the novel. Isaka Kōtarō's Maria Beetle theory.",
				new Date(5, 8, 2022), Arrays.asList(new Author("David Leitch", 47)), Arrays.asList("Zak Olkewicz"),
				Arrays.asList("Columbia Pictures", "87North Productions"),
				Arrays.asList(new Actor("Aaron Taylor-Johnson", 32), new Actor("Brad Pitt", 59),
						new Actor("Joey King", 23), new Actor("Bad Bunny", 29)),
				Arrays.asList("English", "Jappanese", "Russian"),
				"Ladybug is a skilled assassin who just returned from retirement. He receives a mission from assassin Maria Beetle to recover a suitcase on a bullet train in Japan. Thinking this would be an easy mission, a series of events occurred. Ladybug has to face a multitude of different forces on the same train targeting the other suitcase. His opponents are Lemon, Kimura, Hornet, Prince and Tangerine, respectively. Everyone has their own plots and ways of operating that lead to an extremely confusing situation.");
		List<ShowTime> s17 = Arrays.asList(new ShowTime(14, 35, 0, new Date(21, 1, 2023)),
				new ShowTime(18, 30, 0, new Date(22, 2, 2023)));
		InfoMovie i17 = new InfoMovie(id++ + "", m17, s17);

		Movie m18 = new Movie(imgsMovies.get(17), "Shang-Chi and the Legend of the Ten Rings", price,
				EnumTypeMovie.Action_Movie,
				"Shang-Chi and the Legend of the Ten Luan is a 2021 American superhero film based on the Marvel Comics character Shang-Chi. Produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures, it is the 25th feature film in the Marvel Cinematic Universe.",
				new Date(2, 9, 2021), Arrays.asList(new Author("Destin Daniel Cretton", 44)),
				Arrays.asList("Marvel Comics"), Arrays.asList("Marvel Studios"),
				Arrays.asList(new Actor("Awkwafina", 34), new Actor("Dương Tử Quỳnh", 60),
						new Actor("Stephanie Hsu", 32), new Actor("Lưu Tư Mộ", 34)),
				Arrays.asList("English", "Chinese"),
				"Thousands of years ago, Tu Van Vu (Mandarin) found the Ten Wheels, ten mystical weapons that give the user immortality and great power. Van Vu amassed an army of warriors known as the Ten Wheels and conquered many kingdoms and overthrown governments throughout history. In 1996, Wen Yu began searching for the village of Dai La (大羅), which is said to contain many summoned beasts, to expand his power. He found the entrance to the village, but was prevented from entering by the village's guardian, Anh Le. The two fell in love and had two children, named Shang-Chi (Shang Qi) and Xialing (Ha Linh). Van Vu gave up the Ten Wheels and his organization to come to his family. However, Anh Le was murdered by the Gang Gang, the former rival of the Ten Wheels, and Wen Yu once again restored the Ten Wheels to slaughter them and resume his criminal activities. Shang-Chi began to practice martial arts and was sent by Van Vu at the age of 14 to assassinate the leader of the Gang. After completing his mission, a traumatized Shang-Chi escapes to San Francisco, where he takes the name \"Shaun\".");
		List<ShowTime> s18 = Arrays.asList(new ShowTime(15, 45, 0, new Date(21, 1, 2023)),
				new ShowTime(17, 20, 0, new Date(22, 1, 2023)));
		InfoMovie i18 = new InfoMovie(id++ + "", m18, s18);

		Movie m19 = new Movie(imgsMovies.get(18), "Spider-Man: No Way Home", price, EnumTypeMovie.Action_Movie,
				"Spider-Man: No Home is a 2021 American superhero film based on the Marvel Comics character Peter Parker, co-produced by Columbia Pictures and Marvel Studios and distributed by Sony Pictures Releasing.",
				new Date(17, 12, 2021), Arrays.asList(new Author("Jon Watts", 41)),
				Arrays.asList("Chris McKenna", "Erik Sommers"),
				Arrays.asList("Columbia Pictures", "Marvel Studios", "Pascal Pictures"),
				Arrays.asList(new Actor("Tom Holland", 26), new Actor("Zendaya", 26), new Actor("Tobey Maguire", 47),
						new Actor("Andrew Garfield", 39)),
				Arrays.asList("English"),
				"After Quentin Beck-Mysterio posted a video about Spider-Man, causing people around the world to misunderstand Spider-Man killing him and revealing his true identity as Peter Parker, Peter's aunt May, MJ and Ned Leeds were questioned. counsel, but all charges were dropped with the help of attorney Matt Murdock. Parker, MJ, and Ned apply to MIT, but the application is denied due to MJ and Ned's relationship with Spider-Man. Parker visits the Sanctum Sanctorum to ask the ultimate wizard, Stephen Strange, for help, and Strange suggests an ancient spell that can make people forget Peter Parker is Spider-Man. However, while Strange cast the spell, Peter repeatedly requested changes, causing it to become faulty and causing those who knew of Spider-Man's true identity in other universes to be dragged into time. main of the MCU universe.");
		List<ShowTime> s19 = Arrays.asList(new ShowTime(10, 0, 0, new Date(21, 2, 2023)),
				new ShowTime(17, 20, 0, new Date(23, 2, 2023)));
		InfoMovie i19 = new InfoMovie(id++ + "", m19, s19);

		infoMovies.addAll(
				Arrays.asList(i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19));
	}

	// Tạo nhân viên
	private void createStaffs() {
		// TODO Auto-generated method stub
		List<Image> imgsEmployee = mapImg.get("employee");

		Date d1 = new Date(12, 10, 2003);
		Address a1 = new Address("72/5", "Do Van Day", "Tp.HCM");
		Work wk1 = new Work(new Date(12, 1, 2023), EnumPositionStaff.Ticket_Office, EnumStatusType.COMPLETE);
		Work wk2 = new Work(new Date(23, 1, 2023), EnumPositionStaff.Ticket_Office, EnumStatusType.COMPLETE);
		Work wk3 = new Work(new Date(25, 1, 2023), EnumPositionStaff.Ticket_Office, EnumStatusType.COMPLETE);
		List<Work> w1 = Arrays.asList(wk1, wk2, wk3);
		Staff s1 = new Staff(imgsEmployee.get(0), "21130449", "Nguyễn Khải Nam", EnumPosition.Staff, 200, d1, a1,
				"21130449@st.hcmuaf.edu.vn", "0395581810", w1);

		Date d2 = new Date(23, 11, 2003);
		Address a2 = new Address("72", "Phan Van Hon", "Tp.HCM");
		Work wk4 = new Work(new Date(12, 2, 2023), EnumPositionStaff.Ticket_Office, EnumStatusType.LATE);
		Work wk5 = new Work(new Date(23, 2, 2023), EnumPositionStaff.Ticket_Office, EnumStatusType.LATE);
		Work wk6 = new Work(new Date(25, 2, 2023), EnumPositionStaff.Ticket_Office, EnumStatusType.LATE);
		List<Work> w2 = Arrays.asList(wk4, wk5, wk6);
		Staff s2 = new Staff(imgsEmployee.get(1), "21130448", "Cao Thành Nam", EnumPosition.Staff, 180, d2, a2,
				"21130448@st.hcmuaf.edu.vn", "0395581810", w2);

		Date d3 = new Date(12, 12, 2003);
		Address a3 = new Address("5", "Do Van Day", "Tp.HCM");
		Work wk7 = new Work(new Date(12, 3, 2023), EnumPositionStaff.Ticket_Office, EnumStatusType.FAIL);
		Work wk8 = new Work(new Date(23, 3, 2023), EnumPositionStaff.Ticket_Office, EnumStatusType.FAIL);
		Work wk9 = new Work(new Date(25, 3, 2023), EnumPositionStaff.Ticket_Office, EnumStatusType.FAIL);
		List<Work> w3 = Arrays.asList(wk7, wk8, wk9);
		Staff s3 = new Staff(imgsEmployee.get(2), "21130501", "Nguyễn Ngọc Minh Quốc", EnumPosition.Staff, 230, d3, a3,
				"21130501@st.hcmuaf.edu.vn", "0395581810", w3);

		Date d4 = new Date(1, 1, 2003);
		Address a4 = new Address("12b/3", "Do Van Day", "Tp.HCM");
		Work wk10 = new Work(new Date(12, 4, 2023), EnumPositionStaff.Ticket_Office, EnumStatusType.FAIL);
		Work wk11 = new Work(new Date(23, 4, 2023), EnumPositionStaff.Ticket_Office, EnumStatusType.FAIL);
		Work wk12 = new Work(new Date(25, 4, 2023), EnumPositionStaff.Ticket_Office, EnumStatusType.FAIL);
		List<Work> w4 = Arrays.asList(wk10, wk11, wk12);
		Staff s4 = new Staff(imgsEmployee.get(3), "21130432", "Đặng Thanh Long", EnumPosition.Staff, 200, d4, a4,
				"21130432@st.hcmuaf.edu.vn", "0395581810", w4);

		Date d5 = new Date(24, 12, 2003);
		Address a5 = new Address("2", "Do Van Day", "Tp.HCM");
		Work wk13 = new Work(new Date(12, 5, 2023), EnumPositionStaff.Ticket_Office, EnumStatusType.LATE);
		Work wk14 = new Work(new Date(23, 5, 2023), EnumPositionStaff.Ticket_Office, EnumStatusType.LATE);
		Work wk15 = new Work(new Date(25, 5, 2023), EnumPositionStaff.Ticket_Office, EnumStatusType.LATE);
		List<Work> w5 = Arrays.asList(wk13, wk14, wk15);
		Staff s5 = new Staff(imgsEmployee.get(4), "21130454", "Lư Trần Bảo Ngọc", EnumPosition.Staff, 200, d5, a5,
				"21130454@st.hcmuaf.edu.vn", "0395581810", w5);

		staffs.addAll(Arrays.asList(s1, s2, s3, s4, s5));
	}

	// Tạo thông tin các quản lý
	private void createManagers() {
		// TODO Auto-generated method stub
		List<Image> imgsEmployee = mapImg.get("employee");

		Date d1 = new Date(24, 12, 2003);
		Address a1 = new Address("6", "Do Van Day", "Tp.HCM");
		Work wk1 = new Work(new Date(12, 1, 2023), null, null);
		Work wk2 = new Work(new Date(23, 3, 2023), null, null);
		Work wk3 = new Work(new Date(25, 4, 2023), null, null);
		List<Work> w1 = Arrays.asList(wk1, wk2, wk3);
		Manager m1 = new Manager(imgsEmployee.get(5), "admin", "admin", EnumPosition.Manager, 500, d1, a1,
				"admin@gmail.com", "0393939393", w1);

		managers.addAll(Arrays.asList(m1));
	}

	// Tạo thông tin về các tài khoản
	private void createAccounts() {
		// TODO Auto-generated method stub
		// Đặt đại là giống nhau
		String encodeNormal = "@";
		for (Staff s : staffs) {
			mapAccounts.put(s.getId(), new Account(s.getId(), encodeNormal));
		}

		// Mk của admin
		String encodeAdmin = "admin";
		for (Manager m : managers) {
			mapAccounts.put(m.getId(), new Account(m.getId(), encodeAdmin));
		}
	}

	// Tạo data hình ảnh
	private void createImg() {
		// TODO Auto-generated method stub

		// Img cho frame
		List<Image> imgsFrame = FunctionImg
				.readImagesInFolder(FunctionImg.getURLFromPathObj(this, pathImg + "frame").toString());

		// Img cho input
		List<Image> imgsInput = FunctionImg
				.readImagesInFolder(FunctionImg.getURLFromPathObj(this, pathImg + "input").toString());

		// Img cho input
		List<Image> imgsDialog = FunctionImg
				.readImagesInFolder(FunctionImg.getURLFromPathObj(this, pathImg + "dialog").toString());

		// Img cho employee
		List<Image> imgsEmployee = FunctionImg
				.readImagesInFolder(FunctionImg.getURLFromPathObj(this, pathImg + "employee").toString());

		// Img cho menu
		List<Image> imgsMenu = FunctionImg
				.readImagesInFolder(FunctionImg.getURLFromPathObj(this, pathImg + "menu").toString());

		// Img cho menu
		List<Image> imgsSearch = FunctionImg
				.readImagesInFolder(FunctionImg.getURLFromPathObj(this, pathImg + "search").toString());

		// Img cho movies
		List<Image> imgsMovies = FunctionImg
				.readImagesInFolder(FunctionImg.getURLFromPathObj(this, pathImg + "movies").toString());

		// Thêm phần tử vào map để ánh xạ từng loại img của các thư mục khác nhau
		mapImg.put("frame", imgsFrame);
		mapImg.put("input", imgsInput);
		mapImg.put("dialog", imgsDialog);
		mapImg.put("employee", imgsEmployee);
		mapImg.put("menu", imgsMenu);
		mapImg.put("search", imgsSearch);
		mapImg.put("movie", imgsMovies);
	}

	public static List<Image> getImgError() {
		// TODO Auto-generated method stub
		return FunctionImg
				.readImagesInFolder(FunctionImg.getURLFromPathObj(new EmptyDatabase(), pathImg + "error").toString());
	}

}
