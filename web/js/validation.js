

function authorValidate(){
    $('#newAuthorForm').validate({
        rules: {
            name: {
                required: true
            }
        },
        messages: {

            name: {
                required: "Введите имя автора"
            }
        }
    });

    $(document).on('click', '.addAuthor',function(){
        if($("#newAuthorForm").valid()){
            addAuthor();
        }
    });
};

function bookValidate(){
    $('#newBookForm').validate({
        rules: {
            name: {
                required: true
            },
            genre: {
                required: true
            }
        },
        messages: {
            name: {
                required: "Введите название"
            },
            genre: {
                required: "Введите жанр"
            }
        }
    });

    $(document).on('click', '.addBook',function(){
        if($("#newBookForm").valid()){
            addBook();
        }
    });
};