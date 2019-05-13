var Script = function () {
    $(function () {
	$.ajax({
    		url:"/admin/roast/roastCountSex",
    		type:"GET",
    		dataType: "json",
            success: function (result) {
            	 new Morris.Donut({
        	        element: 'roast_male',
        	        data: [
        	          {label: '男性发布', value: result.data.man },
			          {label: '女性发布', value: result.data.woman  }
        	        ],
        	          colors: ['#41cac0', '#EE6AA7'],
        	        formatter: function (y) { return Math.round(y/(result.data.woman+result.data.man)*100) + "%" }
        	      });
            }
    	});
    });

}();




