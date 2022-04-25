import axios from '../CustomAxios/axios';

const BookShopService = {
    fetchAuthors: () => {
        return axios.get("/authors");
    },
    fetchBooks: () => {
        return axios.get("/books");
    },
    fetchCountries: () => {
        return axios.get("/countries");
    },
    fetchCategories: () => {
        return axios.get("/categories")
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`)
    },
    addBook: (name, author, availableCopies, category) => {
        return axios.post("/books/add", {
            "name" : name,
            "author" : author,
            "availableCopies" : availableCopies,
            "category" : category

        });
    },
    editBook: (id, name, author, availableCopies, category) => {
        return axios.put(`/books/edit/${id}`, {
            "name" : name,
            "author" : author,
            "availableCopies" : availableCopies,
            "category" : category,

        });
    },
    getBook: (id) => {
        return axios.get(`/books/${id}`);
    }

}

export default BookShopService;
