<div class="widget-main">
	<p>
		<button class="btn btn-primary" ng-click="showAdd()">Add</button>
	</p>											
	<div class="table-responsive">
		<table id="sample-table-1" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>Code</th>
					<th>Headline</th>
					<th>Author</th>															
					<th>Publication</th>
					<th>Published Date</th>
					<th>Modified Date</th>															
					<th></th>
				</tr>
			</thead>
	
			<tbody>
				<tr ng-repeat="article in articles">
					<td>{{article.code}}</td>
					<td>{{article.headline}}</td>
					<td>{{article.author}}</td>
					<td>{{article.publication}}</td>
					<td>{{article.publishedDate}}</td>
					<td>{{article.modifiedDate}}</td>
					<td>
						<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
							<button class="btn btn-xs btn-success" ng-click="articleView(article.id)">
								<i class="icon-eye-open bigger-120"></i>
							</button>
							<button class="btn btn-xs btn-info" ng-click="articleEdit(article.id)">
								<i class="icon-edit bigger-120"></i>
							</button>	
							<button class="btn btn-xs btn-danger" ng-click="articleDelete(article)">
								<i class="icon-trash bigger-120"></i>
							</button>																					
						</div>
					
						<div class="visible-xs visible-sm hidden-md hidden-lg">
							<div class="inline position-relative">
								<button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown">
									<i class="icon-cog icon-only bigger-110"></i>
								</button>
					
								<ul class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">
									<li>
										<a href="#" class="tooltip-info" data-rel="tooltip" title="View Article" ng-click="articleView(article.id)" data-original-title="View">
											<span class="blue">
												<i class="icon-zoom-in bigger-120"></i>
											</span>
										</a>
									</li>
									<li>																			
										<a href="#" class="tooltip-success" data-rel="tooltip" title="Edit Article" ng-click="articleEdit(article.id)" data-original-title="Edit">
											<span class="green">
												<i class="icon-edit bigger-120"></i>
											</span>
										</a>										
									</li>
									<li>
										<a href="#" class="tooltip-error" data-rel="tooltip" title="Delete Article" ng-click="articleDelete(article)" data-original-title="Delete">
											<span class="red">
												<i class="icon-trash bigger-120"></i>
											</span>
										</a>
									</li>																				
								</ul>
							</div>
						</div>
					</td>									
				</tr>			
			</tbody>
		</table>				
	</div>				
</div><!-- /widget-main -->