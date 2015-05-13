<div class="container navbar-margin">
	<#if RequestParameters.error??>
		<div class="alert alert-danger alert-dismissable">
			<button class="close" data-dismiss="alert">&times;</button>
			Badger not found
		</div>
	</#if>
	<#if alert??>
		<div class="alert alert-info alert-dismissable">
			<button class="close" data-dismiss="alert">&times;</button>
			${alert}
		</div>
	</#if>
	<#if alertError??>
		<div class="alert alert-danger alert-dismissable">
			<button class="close" data-dismiss="alert">&times;</button>
			${alertError}
		</div>
	</#if>
	<#if alertSuccess??>
		<div class="alert alert-success alert-dismissable">
			<button class="close" data-dismiss="alert">&times;</button>
			${alertSuccess}
		</div>
	</#if>
</div>