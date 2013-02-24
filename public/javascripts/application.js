var TasksModule = (function () {
    var rowTemplate  = Handlebars.compile($("#task-row-template").html());

    // private api
    var grid = function() {
        return $("#tasks").find("tbody");
    },

    appendRow = function(taskJson) {
        grid().append(rowTemplate(taskJson))
    },

    removeAllRows = function() {
        grid().empty();
    },

    // public api
    reload = function () {
        $.getJSON('/tasks/list', function (data) {
            removeAllRows();
            $.each(data, function (key, val) {
                appendRow(val)
            });
        });
    },

    onReady = function () {
        reload();
    };

    // register document load
    $(document).ready(onReady);

    // expose public api
    return {
        reload: reload
    };
})();
