$.ajax({
    url: 'http://localhost:8080/product/test',
    method : 'GET',

    success: function (resp){
        console.log(resp)
    }
})