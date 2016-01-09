
var Country = Backbone.Model.extend({

});

var Countries = Backbone.Collection.extend({
    model: Country,
    url: '/getCountries'
});


var CountryView = Backbone.View.extend({
    tagName: 'option',
    initialize: function(){
        this.listenTo(this.model,'all', this.render);
    },
    render: function(){
        this.$el.attr('id',
            this.model.get('id')).html(this.model.get('name'));
        return this.$el;
    }
});


var CountriesView = Backbone.View.extend({
    initialize: function(){
        this.template = _.template($('#viewCountries').html());
        this.$el.html(this.template());
        this.listenTo(countries, "all", this.render(countries));
    },
    render: function(countries){
        countries.each(function(model){
            var view = new CountryView({model: model});
            this.$('.countriesList').append(view.render());
        });
    }
});






