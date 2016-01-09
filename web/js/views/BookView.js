
var Book = Backbone.Model.extend({

});

var Books = Backbone.Collection.extend({
    model: Book
});

var BookView = Backbone.View.extend({
    tagName: 'tr',
    events: {
        'click.bookRow': 'selectBookRow'
    },
    initialize: function(){
        this.template = _.template($('#viewBook').html());
        this.listenTo(this.model,'destroy', this.remove);
    },
    render: function(){
        var view = this.template(this.model.toJSON());
        this.$el.html(view);
        return this.$el;
    },

    selectBookRow: function(e){
        $('.booksList tr').css("background-color", "#fff");
        $(e.currentTarget).css("background-color", "#f1f1f1");
        selectedBook = this.model.get('id');
    }
});

var BooksView = Backbone.View.extend({

    initialize: function(){
        this.template = _.template($('#viewBooks').html());
        this.$el.html(this.template());
        this.listenToOnce(books, "all", this.render);
    },

    render: function(books){
        this.$('.booksList').empty();
        books.each(function(model){
            var view = new BookView({model: model});
            this.$('.booksList').append(view.render());
        });
    }

});