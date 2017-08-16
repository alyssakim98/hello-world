package app;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import data.Person;

public class ComparorTester implements Runnable {

	public static void main(String[] args) {
		Thread thread = new Thread(new ComparorTester());
		thread.start();
	}

	public void run() {
		try {
			//useComparator();
			useFilter();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void useComparator(){
		List<Person> persons = getPerson();

		printPerson(
				"person -> person.getAgeDiff",
				persons.stream().sorted((person1, person2)->person1.getAgeDiff(person2)).collect(Collectors.toList())
				);
		
		
		printPerson(
				"Person::getAgeDiff",
				persons.stream().sorted(Person::getAgeDiff).collect(Collectors.toList())
				);

		printPerson(
				"Argument reverse",
				persons.stream().sorted((person1, person2) -> person2.getAgeDiff(person1)).collect(Collectors.toList())
				);
		
		//
		Comparator<Person> compareAsc = (person1, person2) -> person1.getAgeDiff(person2);
		Comparator<Person> compareDesc = compareAsc.reversed();
		
		printPerson(
				"Default method", 
				persons.stream().sorted(compareAsc).collect(Collectors.toList())
				);
		printPerson(
				"Default method. revers()", 
				persons.stream().sorted(compareDesc).collect(Collectors.toList())
				);
		

		//
		printPerson(
				"Other item comparison",
				persons.stream().sorted((person1, person2) -> person1.getName().compareTo(person2.getName())).collect(Collectors.toList())
				);
		
		//
		persons.stream().min(Person::getAgeDiff).ifPresent(youngest -> this.printPerson("ifPresent min", youngest));
		persons.stream().max(Person::getAgeDiff).ifPresent(oldest -> this.printPerson("ifPresent max", oldest));
		
		//
		Function<Person, String> byName = person -> person.getName();
		printPerson(
				"Comparator.comparing: by Name",
				persons.stream().sorted(Comparator.comparing(byName)).collect(Collectors.toList())
				);
		
		// 
		Function<Person, Integer> byAge = person -> person.getAge();
		printPerson(
				"Comparator.comparing: by Age. thenComparing by Name",
				persons.stream().sorted(Comparator.comparing(byAge).thenComparing(byName)).collect(Collectors.toList())
				);
		
		//
		List<Person> olderThan = new ArrayList<>();
		persons.stream().filter(person -> person.getAge() > 20).forEach(person -> olderThan.add(person));
		printPerson(
				"filter: older than",
				olderThan
				);
		
		// 
		List<Person> olderThan20 = persons.stream().filter(person -> person.getAge() > 20).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		printPerson(
				"collect() method has stream, result container collect that stream.",
				olderThan20
				);
		
		// filtering and toList
		printPerson(
				"Collectors.toList().",
				persons.stream().filter(person -> person.getAge() > 20).collect(Collectors.toList())
				);
		
		// Collectors groupingBy
		Map<Integer, List<Person>> groupAge = persons.stream().collect(Collectors.groupingBy(Person::getAge));
		printPerson(
				"Collectors.groupingBy().",
				groupAge.toString()
				);
		
		// Collectors groupingBy ==> mapping
		Map<Integer, List<String>> groupList = persons.stream().collect(
				Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList()))
				);
		printPerson(
				"Collectors.groupingBy().",
				groupList.toString()
				);
		
		// Collectors groupingBy ==> reducing
		Comparator<Person> byAgeComp = Comparator.comparing(Person::getAge);
		Map<Character, Optional<Person>> oldestPerson = persons.stream().collect(
				Collectors.groupingBy(person -> person.getName().charAt(0),
				Collectors.reducing(BinaryOperator.maxBy(byAgeComp)))
				);
		printPerson(
				"Collectors.groupingBy() & reducing BinaryOperator maxBy.",
				oldestPerson.toString()
				);
	}

	private List<Person> getPerson() {
		List<Person> persons = Arrays.asList(
				new Person("John", 20),
				new Person("Sarah", 21),
				new Person("Doe", 21),
				new Person("Greg", 35));
		
		return persons;
	}

	private void printPerson(String comment, List<Person> persons) {
		System.out.println("===========< "+comment+" >===========");
		persons.forEach(System.out::println);
	}

	private void printPerson(String comment, Person person) {
		System.out.println("===========< "+comment+" >===========");
		System.out.println(person.toString());
	}

	private void printPerson(String comment, String person) {
		System.out.println("===========< "+comment+" >===========");
		System.out.println(person);
	}

	
	private void useFilter() throws IOException, InterruptedException {
		// High-order Convenience Function
		printFiles(
				"Files.list",
				Files.list(Paths.get("D:\\_DEV-Test")).collect(Collectors.toList())
				);
		
		//
		printFiles(
				"Filter directory",
				Files.list(Paths.get("D:\\_DEV-Test")).filter(Files::isDirectory).collect(Collectors.toList())
				);
		
		// 
		printFiles(
				"Files newDirectoryStream endWidth(\".txt\")",
				Files.newDirectoryStream(Paths.get("D:\\_DEV-Test"), path -> path.toString().endsWith(".txt"))
				);
		//
		printFiles(
				"listFiles(file -> file.isHidden())",
				new File("D:\\").listFiles(file -> file.isHidden())
				);
		
		//
		printFiles(
				"listFiles(File::isHidden)",
				new File("D:\\").listFiles(File::isHidden)
				);
		
		//
		System.out.println("===========< flatMap list files>===========");
		List<Serializable> files = Stream.of(new File("D:\\_DEV-Test").listFiles())
				.flatMap(
						file -> file.listFiles() == null 
						? Stream.of(file) : Stream.of(file.listFiles())
						).collect(Collectors.toList());
		System.out.println("File size: "+files.size());

		//
		Path path = Paths.get("D:\\_DEV-Test");
		WatchService watchService = path.getFileSystem().newWatchService();
		path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
		WatchKey watchKey = watchService.poll(1, TimeUnit.MINUTES);
		System.out.println("Report any file chaned within next 1 minute.");
		if( watchKey != null){
			watchKey.pollEvents().stream().forEach(event -> System.out.println(event.context()));
		}
	}
	
	private void printFiles(String comment, List<Path> files) {
		System.out.println("===========< "+comment+" >===========");
		files.forEach(System.out::println);
	}
	
	private void printFiles(String comment, File[] files) {
		System.out.println("===========< "+comment+" >===========");
		Arrays.asList(files).forEach(System.out::println);
	}
	
	private void printFiles(String comment, DirectoryStream<Path> files) {
		System.out.println("===========< "+comment+" >===========");
		files.forEach(System.out::println);
	}
}
