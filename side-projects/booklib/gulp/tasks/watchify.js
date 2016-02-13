/**
 * Created by patrick on 15/11/11.
 */
var gulp           = require('gulp');
var browserifyTask = require('./browserify')

gulp.task('watchify', function(callback) {
    // Start browserify task with devMode === true
    browserifyTask(callback, true);
});
