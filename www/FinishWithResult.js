var cordova = require('cordova');

/**
 * FinishWithResult plugin for Cordova
 * 
 * @constructor
 */
function FinishWithResult () {}

/**
 * Sets the clipboard content
 *
 * @param {String}   uri      The data to return 
 * @param {Function} onSuccess The function to call in case of success 
 * @param {Function} onFail    The function to call in case of error
 */
FinishWithResult.prototype.setResult = function (uri, onSuccess, onFail) {
    if (typeof uri === "undefined" || uri === null) uri = "";
	cordova.exec(onSuccess, onFail, "FinishWithResult", "finish", [uri]);
};


console.log("initilizing FinshWithResult Plugin");
// Register the plugin
var FinishWithResultObj = new FinishWithResult();
module.exports = FinishWithResultObj;
if (!window.plugins) {
    window.plugins = {};
}
if (!window.plugins.FinishWithResultObj) {
    window.plugins.FinishWithResultObj = FinishWithResultObj;
}