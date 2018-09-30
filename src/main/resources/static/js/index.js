function emmitNotification(eventType) {
    $.ajax({
        url: "/event/test",
        method: "POST",
        contentType: 'application/json',
        data: eventType
    }).fail(function(err) {
        alert(err);
    })
}

$("button[event-type]").click(function () {
   emmitNotification($(this).attr("event-type"))
});