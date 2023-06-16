    $('#buttonAdd2Card').click(function() {
        var $modal = $('.modal');
                        //apply custom values where needed
        var $btn = $(this);
        var rowId = $btn.attr('data-id');
        var name = $btn.attr('data-name');
        $modal.find('[data-value="name"]').text(name);

        $modal.find('#addToCard').attr('href', $modal.find('#addToCard').attr('href').replace('_id_', rowId));
        
        $modal.modal();
    });