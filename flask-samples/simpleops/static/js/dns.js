/**
 * Created by patrick on 15/12/28.
 */
$("#dns_id").on("submit", function() {
    var str = $("#ips").serialize();
    //      var url = '/search?' + str
    $.post("/sub?", str, function(res) {
        //$('#listTable').html(res)
        $("#errorMsg").html(res).show();
    });
    return false;
});
