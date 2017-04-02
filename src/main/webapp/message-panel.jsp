<div ng-if="message.alert" ng-class="{alert: message.alert, 'alert-warning': message.warn, 'alert-info': message.info}">
	<button type="button" class="close" data-dismiss="alert" ng-click="clearMessage()">
		<i class="icon-remove"></i>
	</button>
	{{message.content}}
	<br>
</div>	