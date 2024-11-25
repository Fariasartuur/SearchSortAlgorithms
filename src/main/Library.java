package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Library {
	
	static List<Book> books = new ArrayList<>();
	
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
	
	public void searchBook(String isbn) {
		
		Book findBook = binarySearch(isbn);
		
		if (findBook != null) {
            System.out.println("Livro encontrado: " + findBook);
        } else {
            System.out.println("Livro com ISBN " + isbn + " não encontrado.");
        }
		
	}
	
	private static Book binarySearch(String isbn) {
		int first = 0;
		int last = books.size() - 1;
		
		while(first <= last) {
			int mid = first + (last - first) / 2;
			Book midBook = books.get(mid);
			
			int comparison = isbn.compareTo(midBook.getIsbn());
            if (comparison == 0) {
                return midBook;
            } else if (comparison < 0) {
            	last = mid - 1;
            } else {
            	first = mid + 1;
            }
			
		}
		
		return null;
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
