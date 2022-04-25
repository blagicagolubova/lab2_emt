import './App.css';
import React, {Component} from "react";
import Authors from '../Authors/author';
import BookShopService from "../../repository/BookShopRepository";
import 'bootstrap/dist/css/bootstrap.min.css'
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import Countries from "../Countries/countries";
import Books from "../Books/BooksList/books";
import Header from "../Header/header";
import Categories from "../Categories/categories";
import BooksAdd from "../Books/BooksAdd/bookAdd";
import BooksEdit from "../Books/BooksEdit/bookEdit";
class App extends Component {

  constructor(props) {
    super(props);
    this.state = { //state e nekakov objekt
      authors: [],
      books: [],
      countries: [],
        categories: [],
      selectedBook: {}
    }
  }

  render() {
    return (


        <Router>
       <Header/>
            <main>
                <div className="container">
                    <Route path={"/books/edit/:id"} exact render={() =>
                        <BooksEdit categories={this.state.categories}
                                     onEditBook={this.editBook}
                                    book={this.state.selectedBook}/>}/>
                    <Route path={"/books/add"} exact render={() =>
                        <BooksAdd categories={this.state.categories}
                                  onAddBook={this.addBook}/>}/>
                    <Route path={"/books"} exact render={() =>
                        <Books books={this.state.books}
                                  onDelete={this.deleteBook}
                                  onEdit={this.getBook}/>}/>
                    <Route path={"/categories"} exact render={() =>
                        <Categories categories={this.state.categories}/>}/>
                        <Redirect to={"/books"}/>

                </div>
            </main>
        </Router>
    );
  }
    loadAuthors = () => {
        BookShopService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            });
    }
    loadBooks = () => {
        debugger;
        BookShopService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            });

    }
loadCountries = () => {
    BookShopService.fetchCountries()
        .then((data) => {
            this.setState({
                countries: data.data
            })
        });

}
    loadCategories = () => {
        BookShopService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });

    }
    deleteBook = (id) => {
       BookShopService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            });
    }

    addBook = (name, author, availableCopies, category) => {
        debugger;
        BookShopService.addBook(name, author, availableCopies, category)
            .then(() => {
                debugger;
                this.loadBooks();
            });
    }

    getBook = (id) => {
        BookShopService.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            })
    }
    editBook = (id, name, author, availableCopies, category) => {
        BookShopService.editBook(id, name, author, availableCopies, category)
            .then(() => {
                this.loadBooks();
            });
    }
    componentDidMount() {
    this.loadAuthors();
    this.loadBooks();
    this.loadCountries();
    this.loadCategories();

  }



}

export default App;
