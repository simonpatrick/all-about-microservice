/**
 * Created by patrick on 15/11/11.
 */
var gulp = require('gulp');
var config = require('../config');

gulp.task('watch', function() {
    gulp.watch(config.stylus.watch, ['stylus']);
    gulp.watch(config.images.watch, ['images']);
    gulp.watch(config.browserify.watch, ['browserify']);
    gulp.watch(config.vendor.watch, ['vendor']);
});