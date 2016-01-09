
var Author = Backbone.Model.extend({

});

var Authors = Backbone.Collection.extend({
    model: Author,
    url: '/getAuthorsList'
});

var AuthorView = Backbone.View.extend({
    tagName: 'tr',
    events: {
        'click.authorRow': 'selectAuthorRow'
    },
    initialize: function(){
        this.template = _.template($('#viewAuthor').html());
        this.listenTo(this.model,'all', this.render);
    },
    render: function(){
        var view = this.template(this.model.toJSON());
        this.$el.html(view);
        return this.$el;
    },
    selectAuthorRow: function(e){
        $('.authorsList tr').css("background-color", "#fff");
        $(e.currentTarget).css("background-color", "#f1f1f1");
        selectedAuthor = this.model.get('id');
        $.ajax({
            url: '/getBooks',
            type: 'GET',
            dataType: 'json',
            data: {'authorId': selectedAuthor},
            success: function(data){
                books = new Books(data);
                booksView.render(books);
                selectedBook = 0;
            }
        });
    }
});


var AuthorsView = Backbone.View.extend({
    initialize: function(){
        this.template = _.template($('#viewAuthors').html());
        this.$el.html(this.template());
        this.listenToOnce(authors, "all", this.render);
    },

    render: function(){
        this.$('.authorsList').empty();
        authors.fetch();
        authors.each(function(model){
            var view = new AuthorView({model: model});
            this.$('.authorsList').append(view.render());
        });
    }
});

