package com.anii.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.anii.spring5webapp.domain.Author;
import com.anii.spring5webapp.domain.Book;
import com.anii.spring5webapp.domain.Publisher;
import com.anii.spring5webapp.repositories.AuthorRepository;
import com.anii.spring5webapp.repositories.BookRepository;
import com.anii.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Author eric = new Author("Eric", "Lodu");
		Book book = new Book("lauda", "lehsun");

		Publisher pub = new Publisher();
		pub.setName("pub1");
		pub.setCity("city1");
		pub.setState("state1");

		publisherRepository.save(pub);

		eric.getBooks().add(book);
		book.getAuthors().add(eric);

		book.setPublisher(pub);
		pub.getBooks().add(book);

		authorRepository.save(eric);
		bookRepository.save(book);
		publisherRepository.save(pub);

		Author author2 = new Author("Lodu", "eric");
		Book book2 = new Book("lehsun", "lauda");

		author2.getBooks().add(book);
		book2.getAuthors().add(eric);
		book2.setPublisher(pub);
		pub.getBooks().add(book2);

		authorRepository.save(author2);
		bookRepository.save(book2);
		publisherRepository.save(pub);

		System.out.println("Starting");
		System.out.println(bookRepository.count());
		System.out.println(authorRepository.count());
		System.out.println(pub.getBooks().size());
	}

}
