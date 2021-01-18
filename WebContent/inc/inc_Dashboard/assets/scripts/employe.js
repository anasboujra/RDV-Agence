/**
 * 
 */

$('#confirm-delete').on('show.bs.modal', function(e) {
    $(this).find('.btn-delete').attr('href', $(e.relatedTarget).data('href'));
});

$('#confirm-conge').on('show.bs.modal', function(e) {
    $(this).find('.btn-suspend').attr('href', $(e.relatedTarget).data('href'));
});