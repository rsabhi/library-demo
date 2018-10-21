let url = "/demo"
function initPeopleDataGrid() {
  $('#people_datagrid').datagrid({
    title: 'People List',
    method: 'GET',
    pagination: false,
    pageSize: 20,
    pageList: [10, 20, 50, 100],
    pageNumber: 1,
    rownumbers: true,
    singleSelect: true,
    toolbar: '#toolbar',
    idField: 'id',
    height: 'auto',
    columns: [
      [
        {field: 'id', hidden: 'true'},
        {field: 'name', title: 'Name', width: '120px'},
        {field: 'gender', title: 'Gender', width: '120px'},
        {field: 'address', title: 'Address', width: '300px'},
        {field: 'phoneNumber', title: 'Tel', width: '200px'},
        {field: 'action', title: 'Books Borrowed', width: "200px",
          formatter: function (v, row, i) {
            let books = JSON.stringify(row).replace(/"/g, "'");
            return '<a href="javascript:void(0)" onclick="loadBorrowedBooksData(' + books
                + ')">View</a> ';
          }}
      ]
    ]
  });
  // pagination
//  $('#people_datagrid').datagrid('getPager').pagination({
//    onSelectPage: function (pPageIndex, pPageSize) {
//      load(pPageIndex, pPageSize);
//    }
//  });
  //Get data and bind
}
function initBookDataGrid() {
  $('#book_datagrid').datagrid({
    title: 'Book List',
    method: 'GET',
    url: null,
    pagination: false,
    pageSize: 20,
    pageList: [10, 20, 50, 100],
    pageNumber: 1,
    rownumbers: true,
    singleSelect: true,
    toolbar: '#toolbar',
    idField: 'id',
    height: 'auto',
    columns: [
      [
        {field: 'id', hidden: 'true'},
        {field: 'name', title: 'Name', width: '300px'},
        {field: 'author', title: 'Author', width: '120px'},
        {field: 'price', title: 'Price', width: '120px'},
        {field: 'isbn', title: 'ISBN', width: '200px'}
      ]
    ]
  });
  // pagination
//  $('#book_datagrid').datagrid('getPager').pagination({
//    onSelectPage: function (pPageIndex, pPageSize) {
//      load(pPageIndex, pPageSize);
//    }
//  });
  //Get data and bind
}

function initBorrowedBooksDataGrid() {
  $('#borrowed_books_datagrid').datagrid({
    title: null,
    url: null,
    pagination: false,
    rownumbers: true,
    singleSelect: true,
    idField: 'id',
    height: 'auto',
    columns: [
      [
        {field: 'name', title: 'Name', width: '250px'},
        {field: 'author', title: 'Author', width: '100px'},
        {field: 'price', title: 'Price', width: '100px'},
        {field: 'isbn', title: 'ISBN', width: '150px'}
      ]
    ]
  });
}
function loadPeopleData() {
  $.ajax({
    url: url + '/users',
    type: 'GET',
    contentType: "application/json; charset=utf-8",
    dataType: 'json'
  }).done(function (data) {
    console.log(data);
    $('#people_datagrid').datagrid('loadData', {
      "total": data.length,
      "rows": data
    });
  });
}

function loadBookData() {
  $.ajax({
    url: url + '/books',
    type: 'GET',
    contentType: "application/json; charset=utf-8",
    dataType: 'json'
  }).done(function (data) {
    console.log(data);
    $('#book_datagrid').datagrid('loadData', {
      "total": data.length,
      "rows": data
    });
  });
}

function loadBorrowedBooksData(data) {
  let books = data.books;
  $('#borrowed_books_datagrid').datagrid('loadData', {
    "total": books.length,
    "rows": books
  });

  $('#people_borrowed_booksf_dlg').dialog({
    height: 150 + books.length * 30
  }).dialog('open').dialog('setTitle', 'User: ' + data.name + ' - Borrowed Books');
}

function initBasePage() {
  initPeopleDataGrid(); // set up table for people
  initBorrowedBooksDataGrid(); // set up the book view (books borrowed)
  initBookDataGrid(); // table for book
  loadPeopleData(); // load user data
  loadBookData(); // load book data
}
