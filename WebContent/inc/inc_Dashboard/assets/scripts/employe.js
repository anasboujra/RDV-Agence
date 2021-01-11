/**
 * 
 */

$('#confirm-delete').on('show.bs.modal', function(e) {
    $(this).find('.btn-delete').attr('href', $(e.relatedTarget).data('href'));
});