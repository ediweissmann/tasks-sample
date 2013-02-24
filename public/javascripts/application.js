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

    initCreateForm = function() {
        $form = $("#create-task-form");

        var resetForm = function() {
            $form.each(function(){
                this.reset();
            });
        };

        $form.submit(function(e) {
            e.preventDefault();

            var formData = $form.serializeObject();
            if(formData.title.length == 0) {
                return;
            }

            $.ajax({
                data: formData,
                dataType: "json",
                success: function(data){
                    if(data.success) {
                        reload();
                        resetForm();
                    } else {
                        // todo: handle validation failure
                    }
                },
                error: function(jqXHR, textStatus, errorThrown){
                    // todo: handle transport failure
                },
                type: 'POST',
                url: '/tasks/create'
            });
            return false;
        });
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
        initCreateForm();
    };

    // register document load
    $(document).ready(onReady);

    // expose public api
    return {
        reload: reload
    };
})();


// Helpers

// jquery form to object
$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
