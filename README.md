## 用户管理 ##
### 1、获取用户列表 ###


> GET：http://localhost:84/user/userlist?currentpage=1&pagesize=5

参数：

| 参数      | currentpage  | pagesize  |
| ------------- |:-------------:| -----:|
| 默认值  | 1    |   10 |
| 含义  | 当前页    |   每页显示的数量 |


返回值

    {
	"total": 79,
	"data": [{
		"id": 230,
		"openid": "o5hD-44zN3233QhYdPbu-OtU05II",
		"nickname": "发条陳",
		"avatarurl": "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL7jOVvA3ek3yIPDJmOzeC6oCmIGHnTD0k0ic8Ttyg24icSiasK71UKKhK21gNia7XfnOb2tzicR1CeHJw/132",
		"province": "",
		"city": "Israel",
		"gender": 2,
		"email": null,
		"phonenumber": null,
		"signtime": "2019-03-03 14:33:10",
		"recenttime": null
	}, {
		"id": 231,
		"openid": "undefined",
		"nickname": "发条陳",
		"avatarurl": "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL7jOVvA3ek3yIPDJmOzeC6oCmIGHnTD0k0ic8Ttyg24icSiasK71UKKhK21gNia7XfnOb2tzicR1CeHJw/132",
		"province": "",
		"city": "Israel",
		"gender": 2,
		"email": null,
		"phonenumber": null,
		"signtime": "2019-03-03 14:33:39",
		"recenttime": null
	}]
	}

### 2、获取用户信息 ###

> GET：http://localhost:84/user/userinfo?openid=o5hD-44zN3233QhYdPbu-OtU05II

参数:



| 参数      | openid  |   |
| ------------- |:-------------:| -----:|
| 含义  | 用户唯一标识      |    |



返回值:

    {
	"data": {
		"id": 230,
		"openid": "o5hD-44zN3233QhYdPbu-OtU05II",
		"nickname": "发条陳",
		"avatarurl": "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL7jOVvA3ek3yIPDJmOzeC6oCmIGHnTD0k0ic8Ttyg24icSiasK71UKKhK21gNia7XfnOb2tzicR1CeHJw/132",
		"province": "",
		"city": "Israel",
		"gender": 2,
		"email": null,
		"phonenumber": null,
		"signtime": "2019-03-03 14:33:10",
		"recenttime": null
		}
	}


### 3、获取用户总数和用户日增量 ###

> GET ：http://localhost:84/user/usercont

参数：

| 参数      | 无 |
| -------------:| 


| 参数      | 无  |   |
| ------------- |:-------------:| -----:|


返回值

    {"currentCount":79,"increaseCount":20}


### 4、获取用户性别统计 ###

> GET：http://localhost:84/user/sexcount

参数：

| 参数      | 无  |   |
| ------------- |:-------------:| -----:|

返回值

    {"data":{"woman":76,"man":2,"UNKnow":1}}
    



## 表白墙管理 ##

### 1 获取表白墙列表 ###

> GET ：http://localhost:84/confession/conflist

参数：

| 参数      | currentpage  |  pagesize |
| ------------- |:-------------:| -----:|
| 含义  | 当前页      |   每页显示条数 |
| 是否可为空  | 是，  默认值 1    |   是， 默认值 10 |


返回值

    
    {
    	"total": 2,
    	"data": [{
    		"id": "642380f6-3d91-11e9-8b7e-525400f4c464",
    		"content": "ddduddh",
    		"time": "2019/03/03",
    		"likedCount": 1,
    		"stateNiming": 1,
    		"user": {
    			"avatar": "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL7jOVvA3ek3yIPDJmOzeC6oCmIGHnTD0k0ic8Ttyg24icSiasK71UKKhK21gNia7XfnOb2tzicR1CeHJw/132",
    			"touser": "hnhb",
    			"fromuser": "就",
    			"userId": "o5hD-44zN3233QhYdPbu-OtU05II",
    			"sex": 2
    		},
    		"image": "http://zwxq.qiqibl.com/tmp/wxd850d0c58c0ae310.o6zAJszu-hBaGQ3Ucg1iRCuUIyN4.svdnXhDS8Awa9e8582d684d358eb47207440dc979e1c.jpg"
    	}, {
    		"id": "cf3f6ad4-3d8f-11e9-8b7e-525400f4c464",
    		"content": "绿毛水怪啦啦啦",
    		"time": "2019/03/03",
    		"likedCount": 1,
    		"stateNiming": 1,
    		"user": {
    			"avatar": "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL7jOVvA3ek3yIPDJmOzeC6oCmIGHnTD0k0ic8Ttyg24icSiasK71UKKhK21gNia7XfnOb2tzicR1CeHJw/132",
    			"touser": "绿毛",
    			"fromuser": "hhon'hhon'h'm's红毛",
    			"userId": "o5hD-44zN3233QhYdPbu-OtU05II",
    			"sex": 2
    		},
    		"image": "http://zwxq.qiqibl.com/tmp/wxd850d0c58c0ae310.o6zAJszu-hBaGQ3Ucg1iRCuUIyN4.XbBwm5EmtGgW9e8582d684d358eb47207440dc979e1c.jpg"
    	}]
    }