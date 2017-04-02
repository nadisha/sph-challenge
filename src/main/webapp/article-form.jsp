<div class="widget-main">
	<p>
		<button class="btn btn-primary" ng-click="back()">Back To List</button>
	</p>
	<form class="form-horizontal" name="articleform" ng-submit="addArticle()" id="form-article-add">
		<h4 class="header blue bolder smaller">Article Details</h4>
		
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="form-code"> Code </label>
		
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" placeholder="Code (Number)" ng-readonly="article.id" ng-model="article.code" name="articlecode" required>
				<span class="help-inline col-xs-12 col-sm-7" ng-messages="articleform.articlecode.$error" ng-if="articleform.articlecode.$dirty">
					<span class="middle" ng-message="required">Article code (number) is required.</span>
				</span>						
			</div>
		</div>				

		<div class="space-4"></div>

		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="form-author"> Author </label>
		
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" placeholder="Author" ng-readonly="article.id" ng-model="article.author" name="articleauthor" required>
				<span class="help-inline col-xs-12 col-sm-7" ng-messages="articleform.articleauthor.$error" ng-if="articleform.articleauthor.$dirty">
					<span class="middle" ng-message="required">Author is required.</span>
				</span>						
			</div>
		</div>				
		
		<div class="space-4"></div>

		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="form-headline"> Headline </label>
		
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" placeholder="Headline" ng-readonly="article.id" ng-model="article.headline" name="articleheadline" required>
				<span class="help-inline col-xs-12 col-sm-7" ng-messages="articleform.articleheadline.$error" ng-if="articleform.articleheadline.$dirty">
					<span class="middle" ng-message="required">Headline is required.</span>
				</span>						
			</div>
		</div>				

		<div class="space-4"></div>
		
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="form-publication"> Publication </label>
		
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" placeholder="Publication"  ng-readonly="readonly" ng-model="article.publication" name="articlepublication">						
			</div>
		</div>				

		<div class="space-4"></div>
		
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="form-content">Content</label>
			<div class="col-sm-9">										
				<textarea class="col-xs-10 col-sm-5" placeholder="Content of the Article" ng-readonly="readonly" ng-model="article.content" name="articlecontent"></textarea>
			</div>															
		</div>
		
		<div class="space-4"></div>
		
		<div class="clearfix form-actions" ng-if="!readonly">
			<div class="col-md-offset-3 col-md-9">
				<button class="btn btn-info" type="submit" ng-disabled="articleform.$invalid">
					<i class="icon-ok bigger-110"></i>
					Save
				</button>				
				&nbsp; &nbsp; &nbsp;
				<button class="btn" type="reset" ng-click="back()">
					<i class="icon-undo bigger-110"></i>
					Cancel
				</button>
			</div>
		</div>	
	</form>	
</div>