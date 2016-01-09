
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Справочник книг</title>
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
  </head>
  <body>

    <div class="container main">

        <div class="row">
            <div class="col-lg-5 col-md-5 col-sm-5" id="authors"></div>

            <div class="col-lg-7 col-md-7 col-sm-7" id="books"></div>
        </div>

        <div class="row">
            <div class="buttons">
                <button type="button" class="btn btn-primary " id="newAuthor" data-toggle="modal" >
                    Добавить автора</button>
                <button type="button" class="btn btn-primary" data-toggle="modal" onclick="addBookDialog()">
                    Добавить книгу</button>
                <button type="button" class="btn btn-warning" data-toggle="modal" onclick="deleteAuthorDialog()">
                    Удалить автора</button>
                <button type="button" class="btn btn-warning" data-toggle="modal" onclick="deleteBookDialog()">
                    Удалить книгу</button>
            </div>
        </div>
    </div>

    <!-- Add author -->
    <div class="modal fade" id="addAuthor" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Добавить нового автора</h4>
                </div>
                <div class="modal-body">
                    <form role="form" id="newAuthorForm">
                        <div class="form-group">
                            <label for="authorName">Имя</label>
                            <input type="text" class="form-control" name="name" id="authorName">
                        </div>
                        <div class="form-group" id="country"></div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary addAuthor">Сохранить</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Delete author -->
    <div class="modal fade" id="deleteAuthor" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Удалить автора и его книги?</h4>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary deleteAuthor" >Да</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Нет</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Info Author dialog -->
    <div class="modal fade" id="infoAuthorDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Автор не выбран!</h4>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">ОК</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Add book -->
    <div class="modal fade" id="addBook" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Создать книгу</h4>
                </div>
                <div class="modal-body">
                    <form role="form" id="newBookForm">
                        <div class="form-group">
                            <label for="bookName">Название</label>
                            <input type="text" class="form-control" name="name" id="bookName" >
                        </div>
                        <div class="form-group">
                            <label for="genre">Жанр</label>
                            <input type="text" class="form-control" name="genre" id="genre" >
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary addBook">Сохранить</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Delete book -->
    <div class="modal fade" id="deleteBook" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Удалить книгу?</h4>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary deleteBook">Да</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Нет</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Info Book dialog -->
    <div class="modal fade" id="infoBookDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Книга не выбрана!</h4>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">ОК</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Scripts for backbone -->
    <script type="text/template" id="viewAuthors">
        <table class="table tables" id="author-table">
            <thead>
            <th>Имя</th>
            <th>Страна рождения</th>
            </thead>
            <tbody class="authorsList"></tbody>
        </table>
    </script>

    <script type="text/template" id="viewAuthor">
        <td class="authorRow"><\%=name%></td>
        <td class="authorRow"><\%=countryOfBirth.name%></td>
    </script>

    <script type="text/template" id="viewBooks">
        <table class="table tables" id="book-table">
            <thead>
            <th>Название</th>
            <th>Жанр</th>
            </thead>
            <tbody class="booksList"></tbody>
        </table>
    </script>

    <script type="text/template" id="viewBook">
        <td class="bookRow"><\%=name%></td>
        <td class="bookRow"><\%=genre%></td>
    </script>

    <script type="text/template" id="viewCountries">
        <label for="c">Страна рождения</label>
        <select class="form-control countriesList" id="c">
        </select>
    </script>

    <script src="<c:url value="/resources/bootstrap/js/jquery-2.1.4.min.js"/>"></script>
    <script src="<c:url value="/resources/jquery.validate.min.js"/>"></script>
    <script src="<c:url value="/resources/backbone/underscore.js"/>"></script>
    <script src="<c:url value="/resources/backbone/backbone.js"/>"></script>
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/js/views/CountryView.js"/>"></script>
    <script src="<c:url value="/js/views/BookView.js"/>"></script>
    <script src="<c:url value="/js/views/AuthorView.js"/>"></script>
    <script src="<c:url value="/js/validation.js"/>"></script>
    <script src="<c:url value="/js/main.js"/>"></script>
  </body>
</html>
