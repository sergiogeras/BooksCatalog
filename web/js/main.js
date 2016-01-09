
var selectedAuthor = 0, selectedBook = 0, selectedCountry = 0;

var authors;
var books;
var countries;
var countriesView;

$(function(){
    authors = new Authors();
    authors.fetch();
    countries = new Countries();
    countries.fetch();

    authorsView = new AuthorsView({
        el:'#authors'
    });

    booksView = new BooksView({
       el:'#books'
    });

    authorValidate();
    bookValidate();
});


$(document).on('click','#newAuthor', function(){
    countriesView = new CountriesView({
        el: '#country'
    });
    $('#addAuthor').modal();
} );


function addAuthor(){
    var name = $('#authorName').val();
    selectedCountry = $( ".countriesList option:selected").attr('id');

    if(selectedCountry != 0){
        $.ajax({
            url: '/addAuthor',
            type: 'GET',
            dataType: 'json',
            data: {'name': name, 'countryId': selectedCountry},
            success: function(data){
                $('#addAuthor').modal('hide');
                authors.add(data);
                authorsView.render();
                $('#authorName').val('');
                $('.countryOption').val('');
                selectedCountry = 0;
            },
            error: function () {
                console.log("Error");
            }
        });
    }
}

function addBook(){
    var name = $('#bookName').val();
    var genre = $('#genre').val();
    books.push({name: name, genre: genre, authorId: selectedAuthor});
    booksView.render(books);
    var addedBook = books.at(books.length-1);
    $.ajax({
        url: '/addBook',
        type: 'GET',
        dataType: 'json',
        data: {'id': '', 'name': name, 'genre': genre, 'authorId': selectedAuthor},
        success: function(data){
            $('#addBook').modal('hide');
            addedBook.set({id: data.id })
            $('#bookName').val('');
            $('#genre').val('');
        },
        error: function () {
            console.log("Error");
        }
    });
}

$(document).on('click', '.deleteBook', function deleteBook(){
    $.ajax({
        url: '/deleteBook',
        type: 'GET',
        data: {'bookId': selectedBook},
        success: function(){
            $('#deleteBook').modal('hide');
            books.remove(selectedBook);
            booksView.render(books);
            selectedBook = 0;

        },
        error: function(){
            console.log("Error");
        }
    });
});


$(document).on('click','.deleteAuthor',function deleteAuthor(){
    $.ajax({
        url: '/deleteAuthor',
        type: 'GET',
        data: {'authorId': selectedAuthor},
        success: function(){
            $('#deleteAuthor').modal('hide');
            authors.remove(selectedAuthor);
            authorsView.render();
            booksView.render(new Books);
            selectedAuthor = 0;
        },
        error: function(){
            console.log("Error");
        }
    });
});

function deleteAuthorDialog(){
    if(selectedAuthor != 0){
        $('#deleteAuthor').modal();

    } else {
        $('#infoAuthorDialog').modal();
    }
}

function addBookDialog(){
    if(selectedAuthor != 0){
        $('#addBook').modal();
    } else {
        $('#infoAuthorDialog').modal();
    }
}

function deleteBookDialog(){
    if(selectedBook != 0){
        $('#deleteBook').modal();

    } else {
        $('#infoBookDialog').modal();
    }
}
