package org.javatest.springbootjsf.view;

import lombok.Data;
import org.javatest.springbootjsf.model.Book;
import org.javatest.springbootjsf.repositories.BookRepository;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

import static javax.faces.application.FacesMessage.SEVERITY_INFO;
import static javax.faces.context.FacesContext.getCurrentInstance;

@ManagedBean(name = "model", eager = true)
@RequestScoped
@Data
public class BookModel {

    @ManagedProperty(value = "#{bookRepository}")
    private BookRepository bookRepository;

    @ManagedProperty(value = "#{book}")
    private Book book;

    public String doCreateBook() {
        Book created = new Book();
        created.setId(this.book.getId());
        created.setTitle(this.book.getTitle());
        created.setPrice(this.book.getPrice());
        created.setNbofpage(this.book.getNbofpage());
        created.setDescription(this.book.getDescription());
        Book newBook = this.bookRepository.save(created);

        getCurrentInstance().addMessage("errors",
                new FacesMessage(SEVERITY_INFO, "Book created",
                        "The book " + created.getTitle() + " has been created with id=" + newBook.getId()));

        this.book.setTitle("");
        this.book.setPrice(null);
        this.book.setDescription("");
        this.book.setIllustrations(false);
        this.book.setNbofpage(null);

        return "index.xhtml";
    }

    public void doFindBookById() {
        Book found = bookRepository.findOne(this.book.getId());
        this.book.setId(found.getId());
        this.book.setTitle(found.getTitle());
        this.book.setPrice(found.getPrice());
        this.book.setNbofpage(found.getNbofpage());
        this.book.setDescription(found.getDescription());
        this.book.setDescription(found.getDescription());
    }

    public List<Book> findAllBooks() {
        return this.bookRepository.findAll();
    }

}
