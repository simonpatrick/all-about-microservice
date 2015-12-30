var gulp = require('gulp');
var jshint = require('gulp-jshint');
//var concat = require('gulp-concat');
//var uglify = require('gulp-uglify');
//var rename = require('gulp-rename');
//var sass = require('gulp-sass');

//gulp.task('default', function(){
//    gulp.run('lint', 'sass', 'scripts');
//    gulp.watch('./static/js/*.js', function(){
//        gulp.run('lint', 'sass', 'scripts');
//    });
//});

gulp.task('default',['copy-js']);

gulp.task('copy-js',function(){
    //var assets={
    //    js:[
    //        './node-modules/bootstrap/dist/bootstrap.min.js',
    //
    //    ],
    //    css:[
    //        './node-modules/font-awesome/css/font-awesome.min.css'
    //    ]
    //};
    //
    //var js_source = assets['js'];
    //console.log(js_source)
    //for (var i = 0; i < js_source.length; i++) {
    //    var jsSrc = js_source[i];
    //    console.log(jsSrc);
    //    gulp.src(jsSrc).pipe(gulp.dest('static/js/'));
    //}
    //assets.forEach(function(asset,type){
    //    gulp.src(assets).pipe(gulp.dist('./static/'+type))
    //})

    gulp.src('./node-modules/*').pipe(gulp.dest('static/'));
});

//gulp.task('lint',function(){
//   gulp.src('static/js/*.js')
//       .pipe(jshint())
//       .pipe(jshint.reporter('default'));
//});
//
//// concate js
//gulp.task('scripts', function() {
//    gulp.src('./static/js/*.js')
//        .pipe(concat('all.js'))
//        .pipe(gulp.dest('./static/js'))
//        .pipe(rename('all.min.js'))
//        .pipe(uglify())
//        .pipe(gulp.dest('./dist'));
//});

