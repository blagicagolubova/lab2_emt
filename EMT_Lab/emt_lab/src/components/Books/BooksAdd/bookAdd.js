import React from 'react';
import {useHistory} from 'react-router-dom';

const BookAdd = (props) => {
    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        name: "",
        author: "",
        availableCopies: 0,
        category: ""

    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        debugger;
        const name = formData.name;
        const author = formData.author;
        const availableCopies = parseInt( formData.availableCopies);
        const category = formData.category;

        props.onAddBook(name,author,availableCopies,category)
        history.push("/books");
    }
    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Book name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder="Enter book name"
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="author">Author</label>
                        <input type="text"
                               className="form-control"
                               id="author"
                               name="author"
                               placeholder="Author"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="availableCopies">Available copies</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder="Available copies"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="category">Category</label>
                        <input type="text"
                               className="form-control"
                               id="category"
                               name="category"
                               placeholder="Category"
                               required
                               onChange={handleChange}
                        />
                    </div>

                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default BookAdd;
