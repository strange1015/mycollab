<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height:100%;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="${defaultUrls.cdn_url}favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="${defaultUrls.cdn_url}favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="${defaultUrls.cdn_url}css/cssVelocityPage.css">
<style media="screen" type="text/css">
#container {
    background-image: url('${defaultUrls.cdn_url}icons/footer_clouds.png');  background-repeat: no-repeat;
    background-position: bottom right;
}

</style>
<title>このアカウントがまだ活性になっていません。</title>
</head>
<body style="height: 100%; margin: 0; padding: 0; width: 100%;">
	<div id="container" style="height:100%;">
		#parse("templates/page/pageHeader.mt")
		<div id="body" >
			<div id="spacing"></div>
			<div id="mainBody">
				<div id="title">
					<h1>このアカウントがまだ活性になっていません。</h1>
				</div>
				<hr size="1">
				<div >
						アカウント活性のため、メールに送信されたリンクをクリックし、アクセスしてください。もしくは、お客様サポートチームにてご連絡ください。
				</div>
				<div style="text-align:right;">
					<button class="v-button v-button-orangebtn" type="button" onclick="return login();">ログイン</button>
				</div>
				#parse("templates/page/pageFooter_ja_JP.mt")
		</div>
	</div>
</body>
<script src="${defaultUrls.cdn_url}js/jquery-1.10.2.min.js"></script>
<script>
	function login(){
		window.location.assign("$!loginURL");
	}
</script>
</html>
