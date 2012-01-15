/**
 * 
 */
namespace = function(){
    var o, d;
    $.each(arguments, function(v) {
        d = arguments[1].split(".");
        o = window[d[0]] = window[d[0]] || {};
        $.each(d.slice(1), function(v2){
            o = o[arguments[1]] = o[arguments[1]] || {};
        });
    });
    return o;
};