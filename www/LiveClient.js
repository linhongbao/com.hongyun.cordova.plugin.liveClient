var exec = require('cordova/exec');

exports.startActivity = function(argum,success, error) {
    exec(success, error, "LiveClient", "startActivity", [argum]);
};