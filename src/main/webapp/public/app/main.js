require.config({
	paths: {
		'angular' : 'assets/js/angular',
		'angular-message' : 'assets/js/angular-messages',
		'bootbox': 'assets/js/bootbox.min',
		'$': 'assets/js/jquery-2.0.3.min',
		'bootstrap': 'assets/js/bootstrap.min'
	},
	shim: {
		'angular-message': {
			deps: ['angular']
		},
		'angular' : {
			exports : 'angular'
		},
		'bootbox' : {
			deps : ['bootstrap']
		},
		'bootstrap': {
			deps : ['$']	
		}
	}
});

require(['app'], function(app){
	app.init();
});