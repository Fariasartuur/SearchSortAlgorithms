package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Library {
	
	private static List<Book> books = new ArrayList<>();
	
	public Library() {
		runBooks();
	}
	
	private void runBooks() {
		books.add(new Book("978-0061120084", "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book("978-0451524935", "1984", "George Orwell"));
        books.add(new Book("978-0743273565", "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book("978-1503290563", "Pride and Prejudice", "Jane Austen"));
        books.add(new Book("978-0316769488", "The Catcher in the Rye", "J.D. Salinger"));
        books.add(new Book("978-0547928227", "The Hobbit", "J.R.R. Tolkien"));
        books.add(new Book("978-1451673319", "Fahrenheit 451", "Ray Bradbury"));
        books.add(new Book("978-1503280786", "Moby-Dick", "Herman Melville"));
        books.add(new Book("978-0060850524", "Brave New World", "Aldous Huxley"));
        books.add(new Book("978-0486454115", "Crime and Punishment", "Fyodor Dostoevsky"));
        
        Collections.sort(books, Comparator.comparing(Book::getIsbn));
	}
	
	private void printBooks() {
		for(Book b : books) {
			System.out.println("ISBN: " + b.getIsbn() + " - Title: " + b.getTitle() + " - Author: " + b.getAuthor());
		}
	}
	
	public void searchBook(String isbn, Algorithm al) {
		
		printBooks();
		
		List<String> isbns = new ArrayList<>();
		for(Book book : books) {
			isbns.add(book.getIsbn());
		}
		
		Collections.sort(isbns);
		
		String findIsbn = al.binarySearchList(isbns, 0, isbns.size() - 1, isbn);
		
		if (findIsbn != null) {
            for(Book book : books) {
            	if(book.getIsbn().equals(findIsbn)) {
            		System.out.println("Livro encontrado: " + book);
                    return;
            	}
            }
        }
		
		System.out.println("Livro com ISBN " + isbn + " não encontrado.");
	}
	
	class Book {
	    private String isbn;
	    private String title;
	    private String author;

	    public Book(String isbn, String title, String author) {
	        this.isbn = isbn;
	        this.title = title;
	        this.author = author;
	    }

	    public String getIsbn() {
	        return isbn;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public String getAuthor() {
	        return author;
	    }

	    @Override
	    public String toString() {
	        return "Book{" +
	               "ISBN='" + isbn + '\'' +
	               ", Title='" + title + '\'' +
	               ", Author='" + author + '\'' +
	               '}';
	    }
	    
	}

}
