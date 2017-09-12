spring boot 和 springboot-security 、jwt 整合
获取token
	POST 

	http://localhost:8080/auth
	
	Content-Type: application/json
	
	{"username":"1234","password":"1234"}
	
	---
	结果
	
	{
	  "token" : "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjM0IiwiY3JlYXRlZCI6MTUwMzQxMzMwODkxOCwiZXhwIjoxNTA0MDE4MTA4fQ.jQc5MRdgKfi5ds1N0ZSsxkunQQVkFuGJ7Giv1_JrjTiKsu3h7UwE8vjU5wVPaipM_zkbHaMpRqXvF__ci5p7aw"
	}
访问资源
	GET
	
	http://localhost:8080/user-service/bizUser/getUserScore
	
	Content-Type: application/json
	Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjM0IiwiY3JlYXRlZCI6MTUwMzQxMzMwODkxOCwiZXhwIjoxNTA0MDE4MTA4fQ.jQc5MRdgKfi5ds1N0ZSsxkunQQVkFuGJ7Giv1_JrjTiKsu3h7UwE8vjU5wVPaipM_zkbHaMpRqXvF__ci5p7aw
	
	---
	结果
	[
	  {
	    "id": 11,
	    "username": "123",
	    "password": "456",
	    "scoreList": [
	      {
	        "id": 1,
	        "score": 100
	      }
	    ]
	  }
	]