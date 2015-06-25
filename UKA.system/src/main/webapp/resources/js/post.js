
function updateCounter() {
    var len = $("[name='check-disc[]']:checked").length;
    return len;
};

$(function () {
    $("#box-background").change(function() {
        if(this.checked) {
            $('#boxA-background').css('display', 'block');
        } else {
            if (updateCounter() > 0) {
                $('#boxA-background').css('display', 'none');
            } else {
                alert("これ以上消せません。");
                $('#boxA-background').prop('checked', true);
            }
        }
    });
});

$(function () {
    $("#box-parpus").change(function() {
        if(this.checked) {
            $('#boxA-parpus').css('display', 'block');
        } else {
            if (updateCounter() > 0) {
                $('#boxA-parpus').css('display', 'none');
            } else {
                alert("これ以上消せません。");
                $('#boxA-parpus').prop('checked', true);
            }
        }
    });
});

$(function () {
    $("#box-target").change(function() {
        if(this.checked) {
            $('#boxA-target').css('display', 'block');
        } else {
            if (updateCounter() > 0) {
                $('#boxA-target').css('display', 'none');
            } else {
                alert("これ以上消せません。");
                $('#boxA-target').prop('checked', true);
            }
        }
    });
});

$(function () {
    $("#box-search").change(function() {
        if(this.checked) {
            $('#boxA-search').css('display', 'block');
        } else {
            if (updateCounter() > 0) {
                $('#boxA-search').css('display', 'none');
            } else {
                alert("これ以上消せません。");
                $('#boxA-search').prop('checked', true);
            }
        }
    });
});

$(function () {
    $("#box-discription").change(function() {
        if(this.checked) {
            $('#boxA-discription').css('display', 'block');
        } else {
            if (updateCounter() > 0) {
                $('#boxA-discription').css('display', 'none');
            } else {
                alert("これ以上消せません。");
                $('#boxA-discription').prop('checked', true);
            }
        }
    });
});

$(function () {
    $("#box-plan").change(function() {
        if(this.checked) {
            $('#boxA-plan').css('display', 'block');
        } else {
            if (updateCounter() > 0) {
                $('#boxA-plan').css('display', 'none');
            } else {
                alert("これ以上消せません。");
                $('#boxA-plan').prop('checked', true);
            }
        }
    });
});



function add() {
    var val = $(':text[name="komoku-name"]').val();
    if (val.length > 0) {
        var text = '<div class="well" id="boxA-plan"><h4>'+val+'</h4><div class="form-group"><textarea name="text[]" placeholder="1000文字まで..." class="form-control" rows="8" maxlength="1000" class="count_me"></textarea></div><div class="count"><span>1000</span></div><input id="file-0a" name="file[]" class="file" type="file" multiple data-min-file-count="0"><input type="hidden" name="title[]" value="'+val+'" /></div>';
        $("#form-group").append(text).trigger('create');

        // js reload
        var script = document.createElement('script');
        script.src = "/UKA.system/resources/plugins/fileinput/js/fileinput.min.js";
        document.body.appendChild(script);
    }
};
