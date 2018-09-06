$(document).ready(function () {

    // Invoke the corresponding URL to update the contacts section using Ajax
    $('.update-contacts').on('click', 'button[data-update-contacts-url]', function () {
        let url = $(this).data('update-contacts-url');

        // adding the row index, needed when deleting a contact
        let formData = $('form').serializeArray();
        let param = {};
        param["name"] = $(this).attr('name');
        param["value"] = $(this).val();
        formData.push(param);

        // updating the contact section
        $('#tblContacts').load(url, formData);
    });

    // autodismiss alerts
    window.setTimeout(function() {
        $(".alert").fadeTo(500, 0).slideUp(500, function(){
            $(this).remove();
        });
    }, 4000);
});