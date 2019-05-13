$(document).ready(function() {
    /*
     * 展开关闭图片 
     */
    var nCloneTh = document.createElement( 'th' );
    var nCloneTd = document.createElement( 'td' );
    nCloneTd.innerHTML = '<img src="/img/details_open.png">';
    nCloneTd.className = "center";

    $('#roast-table-info thead tr').each( function () {
        this.insertBefore( nCloneTh, this.childNodes[0] );
    } );

    $('#roast-table-info tbody tr').each( function () {
        this.insertBefore(  nCloneTd.cloneNode( true ), this.childNodes[0] );
    } );

    /*
     * Initialse DataTables, with no sorting on the 'details' column
     */
    //debugger
    var oTable = $('#roast-table-info').dataTable( {
    	"serverSide": true,  //启用服务器端分页
    	"bProcessing" : false,
    	"aLengthMenu": [   
    				[5, 15, 20, -1],
                    [5, 15, 20, "All"] // change per page values here
                ],
        "iDisplayLength": 5,
        "aoColumnDefs": [
            { "bSortable": false, "aTargets": [ 0 ] }
        ],
        "aaSorting": [[1, 'asc']],
        "oLanguage": {
                    "sLengthMenu": "_MENU_ 每页显示的条数",
                    "oPaginate": {
                        "sPrevious": "上一页",
                        "sNext": "下一页"
                    },
                    "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                    "sSearch": "搜索发布内容信息："
                    
        },
        "ajax": function (data, callback, settings) {
            //封装请求参数
            //console.log(data);
            var param = {};
            param.pagesize = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
            //param.start = data.start;//开始的记录序号
            param.currentpage = (data.start / data.length)+1;//当前页码
            param.search = data.search.value;
            //param.order = data.order[0]
            //console.log(param);
            //ajax请求数据
	           $.ajax({
	                type: "GET",
	                url: "/admin/roast/roastlist",
	                cache: false,  //禁用缓存
	                data: param,  //传入组装的参数
	                dataType: "json",
	                success: function (result) {
	                    //console.log(result);
	                    //setTimeout仅为测试延迟效果
	                    setTimeout(function () {
	                        //封装返回数据
	                        var returnData = {};
	                        returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回
	                        returnData.recordsTotal = result.total;//返回数据全部记录
	                        returnData.recordsFiltered = result.total;//后台不实现过滤功能，每次查询均视作全部结果
	                        returnData.data = result.data;//返回的数据列表
	                        //console.log(returnData);
	                        //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
	                        //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
	                        callback(returnData);
	                    }, 200);
	                }
	            });
        },
       /*"ajax": {
		      "url": "/admin/roast/roastlist",
		      "dataSrc": "data"
		   },*/
        "aoColumns": [
         	{"data": "id",
         		"render": function(data,type,row,meta){
         			return data = '<img src="/img/details_open.png">'
				}
         	},
         	{"data": "user.avatarurl",
         		"render": function(data,type,row,meta){
         			return data = '<img style="height:30px;width:30px;pointer-events:none;" src="'+data+'"/>'
				}
         	},
         	{
         		"data": "user.nickname"
         	},
         	{
         		"data": "content",
         		"render": function(data,type,row,meta){
         			if(getBLen(data)>15){
         				return data.substr(0,15);
         			}else{
         				return data;
         			}
				}
         	},
         	{"data": "state",
         		"render":function(data,type,row,meta){
         			if(data==0){
         				return data = '<span style="color:red">禁止显示</span>';
         			}else{
         				return data = '<span style="color:green">正常显示</span>'
         			}
         		}
         	},
         	{"data": "createtime"},
         	{"data":null}
        ],
        "aoColumnDefs": [{
			"targets": -1,
			"data": null,
			"defaultContent": '<a class="btn btn-success btn-del_roast" style="margin-left:60px"  href="javascript:;">禁止显示 </a>'
							+'<a class="btn btn-primary btn-revert_roast" style="margin-left:60px"  href="javascript:;">恢复 </a>'
		}]
    });//此处需调用api()方法,否则返回的是JQuery对象而不是DataTables的API对象 .api() https://www.cnblogs.com/huim/p/9514337.html

    /* 
     * 点击展开关闭图片
     */
    $(document).on('click','#roast-table-info tbody td img',function () {
        var nTr = $(this).parents('tr')[0];
        if ( oTable.fnIsOpen(nTr) )
        {
            /* This row is already open - close it */
            this.src = "/img/details_open.png";
            oTable.fnClose( nTr );
        }
        else
        {
            /* Open this row */
            this.src = "/img/details_close.png";
            oTable.fnOpen( nTr, fnFormatDetails(oTable, nTr), 'details' );
        }
    } );
    
    
    $('#roast-table-info tbody').on( 'click', '.btn-del_roast', function () {
		var nTr = $(this).parents('tr')[0];
		var aData = oTable.fnGetData( nTr );
		//发送ajax
		$.ajax({
			url:'/admin/roast/roastChanageStutas',
			type:'post',
			data:{"roastId":aData.id,"funName":"delete"},
			dataType:'json',
			success:function(data){
				if(data.result){
					$('#roast-table-info').DataTable().ajax.reload()
				}
			}
		});
	});
    
    $('#roast-table-info tbody').on( 'click', '.btn-revert_roast', function () {
    	var nTr = $(this).parents('tr')[0];
    	var aData = oTable.fnGetData( nTr );
    	//发送ajax
		$.ajax({
			url:'/admin/roast/roastChanageStutas',
			type:'post',
			data:{"roastId":aData.id,"funName":"restore"},
			dataType:'json',
			success:function(data){
				if(data.result){
					$('#roast-table-info').DataTable().ajax.reload()
				}
			}
		});
    });
    
} );



function fnFormatDetails ( oTable, nTr )
{
    var aData = oTable.fnGetData( nTr );
    var sOut = '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">';
    sOut += '<tr><td>内容详情:</td><td>'+aData.content+'</td></tr>';
    sOut += '<tr><td>用户昵称:</td><td>'+aData.user.nickname+'</td></tr>';
    sOut += '<tr><td>用户头像:</td><td>'+'<img style="height:90px;width:90px;pointer-events:none;" src="'+aData.user.avatarurl+'"/>'+'</td></tr>';
    sOut += '<tr><td>openid:</td><td>'+aData.user.openid+'</td></tr>';
    sOut += '<tr><td>用户省份城市:</td><td>'+aData.user.province+':'+aData.user.city+'</td></tr>';
    sOut += '</table>';

    return sOut;
}


function getBLen(str) {
	  if (str == null) return 0;
	  if (typeof str != "string"){
	    str += "";
	  }
	  return str.replace(/[^\x00-\xff]/g,"01").length;
}
