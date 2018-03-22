var gulp = require('gulp');
var browserify = require('browserify');
var source = require('vinyl-source-stream');
var gutil = require('gulp-util');
var babelify = require('babelify');
var connect = require('gulp-connect');
var pump = require('pump');
var pug = require('gulp-pug');
var htmlmin = require('gulp-htmlmin');
var uglify = require('gulp-uglify');

var dependencies = ['react', 'react-dom'];

gulp.task('server', function() {
    connect.server({
        root: ['./web/'],
        port: 3000,
        base: 'http://localhost',
        livereload: true
    });
});

gulp.task('views', function buildHTML() {
  return gulp.src('./views/*.pug')
  .pipe(pug({
      doctype: 'html',
      pretty: true
  }))
  .pipe(gulp.dest('./dist/'))
});

gulp.task('compress', function (cb) {
  pump([
        gulp.src('./dist/js/*.js'),
        uglify(),
        gulp.dest('./web/js/')
    ],
    cb
  );
});

gulp.task('minify', function() {
  return gulp.src('./dist/*.html')
    .pipe(htmlmin({collapseWhitespace: true}))
    .pipe(gulp.dest('./web/'));
});

gulp.task('scripts', function () {
    bundleApp(false);
});

gulp.task('deploy', function (){
	bundleApp(true);
});

gulp.task('watch', function () {
	gulp.watch(['./app/*.js'], ['scripts']);
    gulp.watch(['./views/*.pug'], ['views']);
    gulp.watch(['./html/*.html'], ['minify']);
    gulp.watch(['./dist/js/*.js'], ['compress']);
});

gulp.task('default', ['scripts','views','minify','compress','watch','server']);

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
        .pipe(gulp.dest('./dist/js/'));
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
    .pipe(gulp.dest('./dist/js/'));
}
