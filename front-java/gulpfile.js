var gulp = require('gulp');
var browserify = require('browserify');
var source = require('vinyl-source-stream');
var gutil = require('gulp-util');
var babelify = require('babelify');
var connect = require('gulp-connect');

var dependencies = ['react', 'react-dom'];

gulp.task('connect', function() {
    connect.server({
        root: ['./web/'],
        port: 3000,
        base: 'http://localhost',
        livereload: true
    });
});

var scriptsCount = 0;

function bundleApp(isProduction) {
    scriptsCount++;
    var appBundler = browserify({
        entries: './app/app.js',
        debug: true
    })

    if (!isProduction && scriptsCount === 1) {
        browserify({
            require: dependencies,
            debug: true
        })
        .bundle()
        .on('error', gutil.log)
        .pipe(source('vendors.js'))
        .pipe(gulp.dest('./web/js/'));
    }
    if (!isProduction) {
        dependencies.forEach(function(dep) {
            appBundler.external(dep);
        })
    }

    appBundler
    .transform("babelify", {presets: ["es2015", "react"]})
    .bundle()
    .on('error', gutil.log)
    .pipe(source('bundle.js'))
    .pipe(gulp.dest('./web/js/'));
}
