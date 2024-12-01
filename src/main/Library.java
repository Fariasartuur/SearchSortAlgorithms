package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Library {
	
	private static List<Livro> books = new ArrayList<>();
	
	public Library() {
		runBooks();
	}
	
	private void runBooks() {
		books.add(new Livro("978-0061120084", "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Livro("978-0451524935", "1984", "George Orwell"));
        books.add(new Livro("978-0743273565", "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Livro("978-1503290563", "Pride and Prejudice", "Jane Austen"));
        books.add(new Livro("978-0316769488", "The Catcher in the Rye", "J.D. Salinger"));
        books.add(new Livro("978-0547928227", "The Hobbit", "J.R.R. Tolkien"));
        books.add(new Livro("978-1451673319", "Fahrenheit 451", "Ray Bradbury"));
        books.add(new Livro("978-1503280786", "Moby-Dick", "Herman Melville"));
        books.add(new Livro("978-0060850524", "Brave New World", "Aldous Huxley"));
        books.add(new Livro("978-0486454115", "Crime and Punishment", "Fyodor Dostoevsky"));
        
        Collections.sort(books, Comparator.comparing(Livro::getIsbn));
	}
	
	private void printBooks() {
		for(Livro b : books) {
			System.out.println("ISBN: " + b.getIsbn() + " - Title: " + b.getTitulo() + " - Author: " + b.getAutor());
		}
	}
	
	public void searchBook(String isbn, Algoritmo al) {
	    printBooks();

	    List<String> isbns = new ArrayList<>();
	    for (Livro book : books) {
	        isbns.add(book.getIsbn());
	    }

	    Collections.sort(isbns);

	    int findIsbnIndex = al.binarySearchList(isbns, isbn);

	    if (findIsbnIndex != -1) {
	        String foundIsbn = isbns.get(findIsbnIndex);
	        
	        for (Livro book : books) {
	            if (book.getIsbn().equals(foundIsbn)) {
	                System.out.println("Livro encontrado: " + book);
	                return;
	            }
	        }
	    }

	    System.out.println("Livro com ISBN " + isbn + " não encontrado.");
	}
	
	class Livro {
	    private String isbn;
	    private String titulo;
	    private String autor;

	    public Livro(String isbn, String titulo, String autor) {
	        this.isbn = isbn;
	        this.titulo = titulo;
	        this.autor = autor;
	    }

	    public String getIsbn() {
	        return isbn;
	    }

	    public String getTitulo() {
	        return titulo;
	    }

	    public String getAutor() {
	        return autor;
	    }

	    @Override
	    public String toString() {
	        return "Livro{" +
	               "ISBN='" + isbn + '\'' +
	               ", Titulo='" + titulo + '\'' +
	               ", Autor='" + autor + '\'' +
	               '}';
	    }
	    
	}

}
