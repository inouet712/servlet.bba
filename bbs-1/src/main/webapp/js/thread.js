/**
 * 
 */
		function check() {
			var flg =0;
			if(document.form1.name.value== "") {
				flg = 1;
			}
			else if(document.form1.content.value == "") {
				flg = 1;
			}
			
			if(flg) {
				window.alert('名前とコメントを入力してください');
				return false;
			}
			else {
				return true;
			}
		}